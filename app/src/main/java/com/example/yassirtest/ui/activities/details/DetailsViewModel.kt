package com.example.yassirtest.ui.activities.details

import androidx.lifecycle.ViewModel
import com.example.yassirtest.domain.movies.entities.MovieEntity
import kotlinx.serialization.json.Json

class DetailsViewModel : ViewModel() {

    lateinit var movieDetails : MovieEntity

    fun init(data: String?) {
        movieDetails = data?.let {
            Json.decodeFromString<MovieEntity>(it)
        }!!
    }

}