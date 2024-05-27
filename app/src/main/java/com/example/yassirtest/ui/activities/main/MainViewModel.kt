package com.example.yassirtest.ui.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yassirtest.domain.movies.entities.MovieEntity
import com.example.yassirtest.domain.movies.entities.MoviesEntity
import com.example.yassirtest.domain.movies.use_cases.GetMoviesUseCase
import com.example.yassirtest.util.FlowState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlin.Exception

class MainViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    var initialFetchFlowState by mutableStateOf<FlowState<Nothing?>>(FlowState.Loading)
        private set
    var recommendedMoviesState = mutableStateListOf<MovieEntity>()
        private set
    var moviesState by mutableStateOf<MoviesEntity?>(null)
        private set
    var movieToDetailState by mutableStateOf<MovieEntity?>(null)
        private set
    var moviesFetchFlowState by mutableStateOf<FlowState<Nothing?>>(FlowState.Success(null))
        private set

    fun initialFetch() {
        initialFetchFlowState = FlowState.Loading
        viewModelScope.launch(Dispatchers.IO) {

            val recommendationMoviesDeferred = async { fetchRecommendedMovies() }
            val moviesDeferred = async { fetchMovies() }

            try {
                recommendationMoviesDeferred.await()
                moviesDeferred.await()
                initialFetchFlowState = FlowState.Success(null)
            } catch (e: Exception) {
                initialFetchFlowState = FlowState.Failure(e)
            } finally {
                recommendationMoviesDeferred.cancelAndJoin()
                moviesDeferred.cancelAndJoin()
            }
        }
    }

    init {
        initialFetch()
    }

    private suspend fun fetchRecommendedMovies() {
        getMoviesUseCase.recommendedMovies().collect {
            if(it is FlowState.Failure) {
                throw Exception(it.exception)
            } else if (it is FlowState.Success) {
                /*
                    IMPORTANT NOTE -----------------------------------------------
                    HERE I DIDN'T LIKE THE IMAGES THAT DISPLAYS IN THE APPLICATION
                    I JUST DID A FILTER FOR TOP 10 RATED MOVIES, BUT UNFORTUNATELY
                    THIS IS WHAT HAPPENS WHEN DEALING WITH NON ISLAMIC API, SO THIS
                    SIMPLE CUSTOMIZATION IS JUST TO HIDE UNWANTED IMAGES TO BE DISPLAYED
                    THE API CONTAINS TOO MANY PROBLEMS SO I HOPE THAT YOU WON'T FACE
                    ANY NULL POINT EXCEPTION :)
                    THANKS ---------------------------------------------------------
                 */
                for (index in 4 .. 5) {
                    val currentData = it.data.results[index]
                    recommendedMoviesState.add(
                        currentData.copy(
                            backdropPath = getMoviePosterUrl(currentData.posterPath),
                            posterPath = getMoviePosterUrl(currentData.posterPath),
                        )
                    )
                }
                for (index in 8 .. 10) {
                    val currentData = it.data.results[index]
                    recommendedMoviesState.add(
                        currentData.copy(
                            backdropPath = getMoviePosterUrl(currentData.posterPath),
                            posterPath = getMoviePosterUrl(currentData.posterPath),
                        )
                    )
                }
            }
        }
    }

    private suspend fun fetchMovies() {
        getMoviesUseCase.invoke().collect {
            if(it is FlowState.Failure) {
                throw Exception(it.exception)
            } else if (it is FlowState.Success) {
                val newResult = arrayListOf<MovieEntity>()
                it.data.results.forEach {
                    newResult.add(
                        it.copy(
                            posterPath = getMoviePosterUrl(it.posterPath),
                            backdropPath = it.backdropPath?.let { it1 -> getMoviePosterUrl(it1) }
                        )
                    )
                }
                moviesState = it.data.copy(
                    results = newResult
                )
            }
        }
    }

    private fun getMoviePosterUrl(endPoint: String) : String {
        return getMoviesUseCase.getMoviePosterUrl(endPoint)
    }

    fun navigateToDetailsScreen(index: Int) {
        movieToDetailState = recommendedMoviesState[index]
    }
    fun navigateToDetailsScreen(movieEntity: MovieEntity) {
        movieToDetailState = movieEntity
    }

    fun finishedNavigation() {
        movieToDetailState = null
    }

    fun goToPage(page: Int) {
        moviesFetchFlowState = FlowState.Loading
        moviesState = null
        viewModelScope.launch(Dispatchers.IO) {
            getMoviesUseCase.invokeInPage(page).collect { flowState ->
                if(flowState is FlowState.Failure) {
                    moviesFetchFlowState = flowState
                } else if (flowState is FlowState.Success) {
                    val newResult = arrayListOf<MovieEntity>()
                    flowState.data.results.forEach {
                        newResult.add(
                            it.copy(
                                posterPath = getMoviePosterUrl(it.posterPath),
                                backdropPath = it.backdropPath?.let { it1 -> getMoviePosterUrl(it1) }
                            )
                        )
                    }
                    moviesState = flowState.data.copy(
                        results = newResult
                    )
                    moviesFetchFlowState = FlowState.Success(null)
                }
            }
        }
    }

}