package com.example.yassirtest.domain.movies.use_cases

import android.util.Log
import com.example.yassirtest.domain.movies.entities.MoviesEntity
import com.example.yassirtest.domain.movies.repositories.MoviesRepository
import com.example.yassirtest.util.FlowState
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun invoke() : Flow<FlowState<MoviesEntity>> {
        return moviesRepository.getMovies()
    }
}