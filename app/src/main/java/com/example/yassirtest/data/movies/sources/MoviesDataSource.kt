package com.example.yassirtest.data.movies.sources

import android.util.Log
import com.example.yassirtest.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLProtocol
import io.ktor.http.appendPathSegments
import io.ktor.http.encodedPath
import io.ktor.http.path

class MoviesDataSource(private val client: HttpClient = KtorClientFactory.create()) {

    private val baseUrl = "https://api.themoviedb.org/3/discover/movie"

    suspend fun getMovies(): HttpResponse {
        val result = client.get(baseUrl) {
            url {
                protocol = URLProtocol.HTTPS
                parameters.append("api_key", BuildConfig.MOVIES_API_KEY)
            }
        }
        return result
    }

}