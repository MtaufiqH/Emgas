package taufiq.apps.core.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import taufiq.apps.core.data.source.local.LocalDataSource
import taufiq.apps.core.data.source.remote.RemoteDataSource
import taufiq.apps.core.data.source.remote.response.ApiResponse
import taufiq.apps.core.data.source.remote.response.GamesResponseResult
import taufiq.apps.core.domain.Game
import taufiq.apps.core.domain.IGameRepository
import taufiq.apps.core.utils.DataMapper
import javax.inject.Inject

/**
 * Created By Taufiq on 5/18/2021.
 *
 */
class GameRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IGameRepository {

    override fun getListGame(key: String): Flow<Resource<List<Game>>> {
        return object : NetworkBoundResource<List<Game>, List<GamesResponseResult>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getListOfGame().map {
                    DataMapper.mapperEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GamesResponseResult>>> {
                return remoteDataSource.getListGames(key)
            }

            override suspend fun saveCallResult(data: List<GamesResponseResult>) {
                val games = DataMapper.mapperResponseToEntity(data)
                localDataSource.insertGame(games)
            }

        }.asFlow()
    }

    override fun getDetailGame(id: String, key: String): Flow<Resource<Game>> {
        return object  : NetworkBoundResource<Game, GamesResponseResult>(){
            override fun loadFromDB(): Flow<Game> {
                return localDataSource.getDetailOfGame(id).map {
                    DataMapper.mapperEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: Game?): Boolean {
                return data == null || data.gameId.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<GamesResponseResult>> {
                return remoteDataSource.getDetailGame(id, key)
            }

            override suspend fun saveCallResult(data: GamesResponseResult) {
                val dataGame = DataMapper.mapperResponsesDetailToEntities(data)
                return localDataSource.insertGame(game = dataGame)
            }

        }.asFlow()
    }

    override fun getFavoriteGame(): Flow<List<Game>> {
        return localDataSource.getFavoriteGameList().map {
            DataMapper.mapperEntitiesToDomain(it)
        }
    }

    override fun updateFavorite(game: Game, state: Boolean) {
        val entity = DataMapper.mapperDomainToEntity(game)
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.updateFavoriteGame(entity, state)
        }
    }

}