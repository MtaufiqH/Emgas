package taufiq.apps.core.data.source.remote.response

/**
 * Created By Taufiq on 5/17/2021.
 *
 */
sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()

}