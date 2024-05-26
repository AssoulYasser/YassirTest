package com.example.yassirtest.domain.movies.repositories

import com.example.yassirtest.domain.movies.entities.MoviesEntity
import com.example.yassirtest.util.FlowState
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getMovies() : Flow<FlowState<MoviesEntity>>
}