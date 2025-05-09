package data.remote.utils

import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import logic.exception.ClothesSuggestException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

inline fun safeApiCall(apiCall: () -> HttpResponse): HttpResponse {
    return try {
        apiCall()
    } catch (e: UnknownHostException) {
        throw ClothesSuggestException.NetworkException.NoInternetException
    } catch (e: SocketTimeoutException) {
        throw ClothesSuggestException.NetworkException.TimeoutException
    } catch (e: Exception) {
        throw ClothesSuggestException.NetworkException.UnknownNetworkException
    }
}

suspend inline fun <reified T> getClassByResponse(response: HttpResponse, json: Json): T {
    return json.decodeFromString<T>(response.bodyAsText())
}