package taufiq.apps.emgas.favgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import taufiq.apps.core.domain.GameUseCase

/**
 * Created By Taufiq on 5/21/2021.
 *
 */
class FavoriteViewModel constructor(private val gameUseCase: GameUseCase) : ViewModel() {
    fun getAllFavoriteGame() = gameUseCase.getFavoriteGame().asLiveData()
}