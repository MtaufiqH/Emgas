package taufiq.apps.core.domain

import kotlinx.coroutines.flow.Flow
import taufiq.apps.core.data.Resource
import javax.inject.Inject

/**
 * Created By Taufiq on 5/17/2021.
 *
 */
class GameInteractor @Inject constructor(private val gameRepository: IGameRepository): GameUseCase {

    override fun getListGame(key: String): Flow<Resource<List<Game>>> {
        return gameRepository.getListGame(key)
    }

    override fun getDetailGame(id: String, key: String): Flow<Resource<Game>> {
        return gameRepository.getDetailGame(id,key)
    }

    override fun getFavoriteGame(): Flow<List<Game>> {
        return gameRepository.getFavoriteGame()
    }

    override fun updateFavorite(game: Game, state: Boolean) {
        return gameRepository.updateFavorite(game, state)
    }
}