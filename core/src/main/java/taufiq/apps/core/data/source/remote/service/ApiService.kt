package taufiq.apps.core.data.source.remote.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import taufiq.apps.core.data.source.remote.response.GamesResponseResult
import taufiq.apps.core.data.source.remote.response.ListGames

/**
 * Created By Taufiq on 5/17/2021.
 *
 */
interface ApiService {

    @GET("games")
    suspend fun getGame(@Query("key") key : String) : ListGames

    @GET("games/{id}")
    suspend fun getDetailGame(@Path("id") pathId : String, @Query("key") key : String) : GamesResponseResult
}