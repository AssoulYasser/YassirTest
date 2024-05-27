package com.example.yassirtest.ui.activities.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.yassirtest.ui.theme.YassirTestTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : ComponentActivity() {
    val detailsViewModel : DetailsViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        detailsViewModel.init(intent.extras?.getString("movie"))
        setContent {
            YassirTestTheme {
                Surface (
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.fillMaxSize()
                ) {
                    DetailsScreen(viewModel = detailsViewModel)
                }
            }
        }
    }

}