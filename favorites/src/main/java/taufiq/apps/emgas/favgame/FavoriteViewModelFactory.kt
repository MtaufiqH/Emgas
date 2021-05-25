package taufiq.apps.emgas.favgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import taufiq.apps.core.domain.GameUseCase
import javax.inject.Inject

/**
 * Created By Taufiq on 5/24/2021.
 *
 */
class FavoriteViewModelFactory @Inject constructor(private val useCase : GameUseCase) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FavoriteViewModel(useCase) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }