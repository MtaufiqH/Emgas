package taufiq.apps.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created By Taufiq on 5/17/2021.
 *
 */
data class ListGames(
    @field:SerializedName("results")
    val results: List<GamesResponseResult>
) {
}