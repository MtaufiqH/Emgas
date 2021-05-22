package taufiq.apps.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import taufiq.apps.core.data.source.local.db.DaoGames
import taufiq.apps.core.data.source.local.db.DatabaseGame
import javax.inject.Singleton

/**
 * Created By Taufiq on 5/18/2021.
 *
 */

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : DatabaseGame  =
        Room.databaseBuilder(context,DatabaseGame::class.java,"games.db").build()

    @Singleton
    @Provides
    fun providesDao(db : DatabaseGame) : DaoGames = db.gameDao()
}