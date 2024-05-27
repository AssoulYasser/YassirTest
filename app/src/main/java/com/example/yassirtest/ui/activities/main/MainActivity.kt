package com.example.yassirtest.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.yassirtest.ui.activities.details.DetailsActivity
import com.example.yassirtest.ui.theme.YassirTestTheme
import com.example.yassirtest.util.FlowState
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            if (mainViewModel.movieToDetailState != null)
                navigateToDetailScreen()
            YassirTestTheme {
                InitUi()
            }
        }
    }

    private fun navigateToDetailScreen() {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("movie", Json.encodeToString(mainViewModel.movieToDetailState))

        startActivity(intent)
        mainViewModel.finishedNavigation()
    }

    @Composable
    private fun InitUi() {
        Surface(
            color = MaterialTheme.colorScheme.secondary
        ) {
            when(mainViewModel.initialFetchFlowState) {
                FlowState.Loading -> LoadingUi()
                is FlowState.Failure -> FailureUi()
                is FlowState.Success -> {
                    MainScreen(viewModel = mainViewModel)
                }
            }
        }
    }

    @Composable
    private fun LoadingUi() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    @Composable
    fun FailureUi() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { mainViewModel.initialFetch() },
            ) {
                Text(text = "Try Again", color = Color.White)
            }
        }
    }

}