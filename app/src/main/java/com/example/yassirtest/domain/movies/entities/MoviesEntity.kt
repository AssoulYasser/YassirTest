package com.example.yassirtest.domain.movies.entities

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class MoviesEntity(
    val page: Int,
    val results: List<MovieEntity>,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int
)