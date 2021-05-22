package taufiq.apps.core.data.source.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import taufiq.apps.core.data.source.remote.response.ApiResponse
import taufiq.apps.core.data.source.remote.response.GamesResponseResult
import taufiq.apps.core.data.source.remote.service.ApiService
import javax.inject.Inject

/**
 * Created By Taufiq on 5/17/2021.
 *
 */
class RemoteDataSource @Inject constructor(private val service: ApiService) {
    suspend fun getListGames(key: String): Flow<ApiResponse<List<GamesResponseResult>>> =
        flow {
            try {
                val response = service.getGame(key)
                val dataGames = response.results
                if (dataGames.isNotEmpty()) emit(ApiResponse.Success(response.results))
                else emit(ApiResponse.Empty)

            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }

        }.flowOn(Dispatchers.IO)


    suspend fun getDetailGame(id: String, key: String): Flow<ApiResponse<GamesResponseResult>> =
        flow {
            try {
                val dataGameDetail = service.getDetailGame(id, key)
                emit(ApiResponse.Success(dataGameDetail))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)

}

