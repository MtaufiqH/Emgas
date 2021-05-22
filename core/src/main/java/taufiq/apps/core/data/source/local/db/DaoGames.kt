package taufiq.apps.core.data.source.local.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import taufiq.apps.core.data.source.local.entity.EntityGames

/**
 * Created By Taufiq on 5/18/2021.
 *
 */
@Dao
interface DaoGames {
    @Query("SELECT * FROM games")
    fun getListGames(): Flow<List<EntityGames>>

    @Query("SELECT * FROM games where isFavorite = 1")
    fun getFavoriteGames(): Flow<List<EntityGames>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(games: List<EntityGames>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: EntityGames)

    @Update
    suspend fun updateFavoriteGames(game: EntityGames)

    @Query("SELECT * FROM games WHERE id = :id")
    fun getDetailGame(id: String): Flow<EntityGames>
}