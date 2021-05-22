package taufiq.apps.emgas.favgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.core.domain.GameUseCase
import javax.inject.Inject

/**
 * Created By Taufiq on 5/21/2021.
 *
 */
@HiltViewModel
class FavoriteViewModel @Inject constructor(private val gameUseCase: GameUseCase) : ViewModel(){
    fun getAllFavoriteGame()  = gameUseCase.getFavoriteGame().asLiveData()
}