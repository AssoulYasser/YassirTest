package com.example.yassirtest.domain.movies.use_cases

import android.util.Log
import com.example.yassirtest.domain.movies.entities.MoviesEntity
import com.example.yassirtest.domain.movies.entities.MoviesFilterEntity
import com.example.yassirtest.domain.movies.entities.SortTypes
import com.example.yassirtest.domain.movies.repositories.MoviesRepository
import com.example.yassirtest.util.FlowState
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun invoke() : Flow<FlowState<MoviesEntity>> {
        return moviesRepository.getMovies()
    }

    suspend fun recommendedMovies() : Flow<FlowState<MoviesEntity>> {
        val filter = MoviesFilterEntity(
            year = LocalDate.now().year,
            sortBy = SortTypes.VOTE_COUNT.getDesc(),
            voteAverageGreatestThan = 9,
            page = 2
        )
        return moviesRepository.getMovies(filter)
    }

    suspend fun invokeInPage(page : Int) : Flow<FlowState<MoviesEntity>> {
        return moviesRepository.getMovies(MoviesFilterEntity(page = page))
    }

    fun getMoviePosterUrl(endPoint: String) : String {
        return moviesRepository.moviePosterUrl(endPoint)
    }
}