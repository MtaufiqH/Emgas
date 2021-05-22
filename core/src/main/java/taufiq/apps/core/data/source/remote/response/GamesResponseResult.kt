package taufiq.apps.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created By Taufiq on 5/17/2021.
 *
 */
data class GamesResponseResult(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("description")
    val description: String?,

    @field:SerializedName("released")
    val released: String?,

    @field:SerializedName("rating")
    val rating: String,

    @field:SerializedName("background_image")
    val imageUrl: String
)
