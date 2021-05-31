package taufiq.apps.emgas.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import taufiq.apps.core.domain.GameUseCase
import taufiq.apps.emgas.BuildConfig

/**
 * Created By Taufiq on 5/19/2021.
 *
 */

class GameViewModels @ViewModelInject constructor(private val useCase: GameUseCase) : ViewModel() {

    fun getDataGame() =
        useCase.getListGame(BuildConfig.API_KEY).asLiveData()
}