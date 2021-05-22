package taufiq.apps.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import taufiq.apps.core.domain.GameInteractor
import taufiq.apps.core.domain.GameUseCase

/**
 * Created By Taufiq on 5/19/2021.
 *
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideUseCase(gameInteractor: GameInteractor): GameUseCase
}