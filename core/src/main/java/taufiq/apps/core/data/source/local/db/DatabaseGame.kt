package taufiq.apps.core.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import taufiq.apps.core.data.source.local.entity.EntityGames

/**
 * Created By Taufiq on 5/18/2021.
 *
 */
@Database(entities = [EntityGames::class], version = 1,exportSchema = false)
abstract class DatabaseGame : RoomDatabase(){

    abstract fun gameDao() : DaoGames
}