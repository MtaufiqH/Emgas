package taufiq.apps.emgas.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import taufiq.apps.core.domain.GameUseCase
import taufiq.apps.core.utils.Constant
import javax.inject.Inject

/**
 * Created By Taufiq on 5/19/2021.
 *
 */

class GameViewModels @ViewModelInject constructor(private val useCase: GameUseCase) : ViewModel() {

    fun getDataGame() =
        useCase.getListGame(Constant.API_KEY).asLiveData()
}