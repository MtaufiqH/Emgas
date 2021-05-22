package taufiq.apps.core.data.source.local

import kotlinx.coroutines.flow.Flow
import taufiq.apps.core.data.source.local.db.DaoGames
import taufiq.apps.core.data.source.local.entity.EntityGames
import javax.inject.Inject

/**
 * Created By Taufiq on 5/18/2021.
 *
 */
class LocalDataSource @Inject constructor(private val daoGames: DaoGames){

    fun getListOfGame()  = daoGames.getListGames()
    fun getDetailOfGame(id: String) = daoGames.getDetailGame(id)
    suspend fun insertGame(gameList: List<EntityGames>)  = daoGames.insertGames(gameList)
    suspend fun insertGame(game: EntityGames) = daoGames.insertGame(game)
    fun getFavoriteGameList(): Flow<List<EntityGames>>  = daoGames.getFavoriteGames()
    suspend fun updateFavoriteGame(game: EntityGames, newState : Boolean){
        game.isFavorite = newState
        daoGames.updateFavoriteGames(game)
    }
}