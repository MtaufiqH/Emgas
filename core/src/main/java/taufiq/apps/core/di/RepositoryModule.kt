package taufiq.apps.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import taufiq.apps.core.data.GameRepository
import taufiq.apps.core.domain.IGameRepository

/**
 * Created By Taufiq on 5/18/2021.
 *
 */
@Module(includes = [RemoteModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(gameRepository: GameRepository): IGameRepository
}