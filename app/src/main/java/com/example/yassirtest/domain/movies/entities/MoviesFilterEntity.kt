package com.example.yassirtest.domain.movies.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement

@Serializable
data class MoviesFilterEntity(
    @SerialName("include_adult") val includeAdult : Boolean? = null,
    @SerialName("page") val page : Int = 1,
    @SerialName("year") val year : Int? = null,
    @SerialName("sort_by") val sortBy : String? = null,
    @SerialName("vote_average.gte") val voteAverageGreatestThan : Int? = null
) {
    fun toQueryParams(): Map<String, String> {
        val jsonElement = Json.encodeToJsonElement(this)
        return (jsonElement as JsonObject).mapValues { it.value.toString() }
    }
}