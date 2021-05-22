package taufiq.apps.emgas.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.core.domain.GameUseCase
import taufiq.apps.core.utils.Constant
import javax.inject.Inject

/**
 * Created By Taufiq on 5/19/2021.
 *
 */
@HiltViewModel
class GameViewModels @Inject constructor(private val useCase: GameUseCase) : ViewModel() {

    fun getDataGame() =
        useCase.getListGame(Constant.API_KEY).asLiveData()
}