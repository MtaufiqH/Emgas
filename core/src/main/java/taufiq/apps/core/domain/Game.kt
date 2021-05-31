package taufiq.apps.core.domain

import android.os.Parcelable

/**
 * Created By Taufiq on 5/17/2021.
 *
 */
@kotlinx.parcelize.Parcelize
data class Game(
    val gameId: String,
    val name: String,
    val description: String?,
    val released: String?,
    val rating: String,
    val imageUrl: String,
    val isFavorite: Boolean
) : Parcelable