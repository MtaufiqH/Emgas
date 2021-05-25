package taufiq.apps.emgas.favgame.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import taufiq.apps.core.di.FavoriteModuleDependencies
import taufiq.apps.emgas.favgame.FavoriteFragment

/**
 * Created By Taufiq on 5/23/2021.
 *
 */
@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {
    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(dependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }

}