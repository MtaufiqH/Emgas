package taufiq.apps.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import taufiq.apps.core.domain.GameInteractor
import taufiq.apps.core.domain.GameUseCase

/**
 * Created By Taufiq on 5/19/2021.
 *
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideUseCase(gameInteractor: GameInteractor): GameUseCase
}