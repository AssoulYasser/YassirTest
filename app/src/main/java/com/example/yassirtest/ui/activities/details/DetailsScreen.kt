package com.example.yassirtest.ui.activities.details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.yassirtest.ui.activities.details.sections.hero.HeroSection
import com.example.yassirtest.ui.activities.details.sections.overview.OverviewSection

@Composable
fun DetailsScreen(modifier: Modifier = Modifier, viewModel: DetailsViewModel) {
    val localConfiguration = LocalConfiguration.current
    val screenHeight = localConfiguration.screenHeightDp.dp
    LazyColumn (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            HeroSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight * 0.45f),
                movie = viewModel.movieDetails
            )
        }
        item {
            OverviewSection(modifier = Modifier.fillMaxWidth().padding(16.dp), overview = viewModel.movieDetails.overview)
        }
    }
}