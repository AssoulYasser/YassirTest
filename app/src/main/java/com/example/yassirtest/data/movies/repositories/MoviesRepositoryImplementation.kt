package com.example.yassirtest.data.movies.repositories

import android.util.Log
import com.example.yassirtest.data.movies.sources.MoviesDataSource
import com.example.yassirtest.domain.movies.entities.MoviesEntity
import com.example.yassirtest.domain.movies.repositories.MoviesRepository
import com.example.yassirtest.util.FlowState
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MoviesRepositoryImplementation(private val moviesDataSource: MoviesDataSource) : MoviesRepository {

    override suspend fun getMovies(): Flow<FlowState<MoviesEntity>> = flow {
        emit(FlowState.Loading)
        try {
            val moviesResponse = moviesDataSource.getMovies()
            emit(FlowState.Success(moviesResponse.body()))
        } catch (e: Exception) {
            emit(FlowState.Failure(e))
        }
    }
}
