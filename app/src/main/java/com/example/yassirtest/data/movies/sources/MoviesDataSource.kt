package com.example.yassirtest.data.movies.sources

import android.util.Log
import com.example.yassirtest.BuildConfig
import com.example.yassirtest.domain.movies.entities.MoviesFilterEntity
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.http.URLProtocol

class MoviesDataSource(private val client: HttpClient = KtorClientFactory.create()) {

    private val baseUrl = "https://api.themoviedb.org/3/discover/movie"
    suspend fun getMovies(filters : MoviesFilterEntity): HttpResponse {
        val result = client.get(baseUrl) {
            url {
                protocol = URLProtocol.HTTPS
                parameters.append("api_key", BuildConfig.MOVIES_API_KEY)
                filters.toQueryParams().forEach { (key, value) ->
                    parameters.append(key, value)
                }
            }
        }
        return result
    }

    fun moviePosterUrl(endPoint: String) : String {
        return "https://image.tmdb.org/t/p/w500$endPoint"
    }
}