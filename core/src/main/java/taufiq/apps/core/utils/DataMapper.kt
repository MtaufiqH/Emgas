package taufiq.apps.core.utils

import taufiq.apps.core.data.source.local.entity.EntityGames
import taufiq.apps.core.data.source.remote.response.GamesResponseResult
import taufiq.apps.core.domain.Game

/**
 * Created By Taufiq on 5/18/2021.
 *
 */
object DataMapper {

    fun mapperResponseToEntity(input: List<GamesResponseResult>): List<EntityGames> {
        val games = ArrayList<EntityGames>()
        input.map {
            val game = EntityGames(
                gameId = it.id,
                description = it.description,
                name = it.name,
                released = it.released,
                rating = it.rating,
                imageUrl = it.imageUrl
            )

            games.add(game)
        }
        return games
    }

    fun mapperResponsesDetailToEntities(input: GamesResponseResult): EntityGames {
        return EntityGames(
            gameId = input.id,
            description = input.description,
            name = input.name,
            released = input.released,
            rating = input.rating,
            imageUrl = input.imageUrl
        )
    }

    fun mapperEntitiesToDomain(input: List<EntityGames>): List<Game> =
        input.map {
            Game(
                gameId = it.gameId,
                description = it.description,
                name = it.name,
                released = it.released,
                rating = it.rating,
                imageUrl = it.imageUrl,
                isFavorite = it.isFavorite
            )
        }

    fun mapperDomainToEntity(input: Game) = EntityGames(
        gameId = input.gameId,
        name = input.name,
        description = input.description,
        released = input.released,
        rating = input.rating,
        imageUrl = input.imageUrl,
        isFavorite = input.isFavorite
    )

    fun mapperEntityToDomain(input: EntityGames) = Game(
        gameId = input.gameId,
        name = input.name,
        description = input.description,
        released = input.released,
        rating = input.rating,
        imageUrl = input.imageUrl,
        isFavorite = input.isFavorite
    )
}