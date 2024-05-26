package com.example.yassirtest.ui.activities.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yassirtest.domain.movies.use_cases.GetMoviesUseCase
import com.example.yassirtest.util.FlowState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    private val TAG = "DEBUGGING"
    fun test() {
        viewModelScope.launch(Dispatchers.IO) {
            getMoviesUseCase.invoke().collect() { state ->
                when(state) {
                    is FlowState.Loading -> {
                        Log.d(TAG, "LOADING ...")
                    }
                    is FlowState.Failure -> {
                        Log.d(TAG, "FAILED :( ${state.exception}")
                    }
                    is FlowState.Success -> {
                        Log.d(TAG, "SUCCESS :) ${state.data}")
                    }
                }
            }
        }
    }
}