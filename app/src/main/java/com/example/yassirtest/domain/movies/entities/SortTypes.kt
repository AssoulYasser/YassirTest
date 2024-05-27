package com.example.yassirtest.domain.movies.entities

enum class SortTypes {
    ORIGINAL_TITLE,
    POPULARITY,
    REVENUE,
    PRIMARY_RELEASE_DATE,
    TITLE,
    VOTE_AVERAGE,
    VOTE_COUNT;

    fun getAsc() = this.name.lowercase().plus(".asc")
    fun getDesc() = this.name.lowercase().plus(".desc")
}