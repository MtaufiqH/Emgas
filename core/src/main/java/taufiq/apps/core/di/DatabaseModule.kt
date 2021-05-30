package taufiq.apps.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import taufiq.apps.core.data.source.local.db.DaoGames
import taufiq.apps.core.data.source.local.db.DatabaseGame
import javax.inject.Singleton

/**
 * Created By Taufiq on 5/18/2021.
 *
 */

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DatabaseGame {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(context, DatabaseGame::class.java, "games.db")
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }


    @Singleton
    @Provides
    fun providesDao(db: DatabaseGame): DaoGames = db.gameDao()
}