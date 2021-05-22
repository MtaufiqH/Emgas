package taufiq.apps.core.domain

import kotlinx.coroutines.flow.Flow
import taufiq.apps.core.data.Resource

/**
 * Created By Taufiq on 5/17/2021.
 *
 */
interface GameUseCase {
    fun getListGame(key: String) : Flow<Resource<List<Game>>>
    fun getDetailGame(id: String, key: String) : Flow<Resource<Game>>
    fun getFavoriteGame(): Flow<List<Game>>
    fun updateFavorite(game: Game, state: Boolean)

}