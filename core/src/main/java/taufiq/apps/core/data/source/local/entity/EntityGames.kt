package taufiq.apps.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Taufiq on 5/18/2021.
 *
 */
@Entity(tableName = "games")
data class EntityGames(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var gameId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "released")
    var released: String?,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "imageUrl")
    var imageUrl: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
