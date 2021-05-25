package taufiq.apps.core.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import taufiq.apps.core.domain.GameUseCase

/**
 * Created By Taufiq on 5/23/2021.
 *
 */

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface FavoriteModuleDependencies {
    fun gameUseCase(): GameUseCase
}