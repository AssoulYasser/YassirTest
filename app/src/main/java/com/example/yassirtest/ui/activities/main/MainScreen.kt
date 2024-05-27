package com.example.yassirtest.ui.activities.main

import android.widget.GridLayout
import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yassirtest.ui.activities.main.sections.movie_item.MovieItem
import com.example.yassirtest.ui.activities.main.sections.pagination.PaginationSection
import com.example.yassirtest.ui.activities.main.sections.recommendation.RecommendationSection
import com.example.yassirtest.util.FlowState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {

    val pagerState = rememberPagerState { 5 }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            RecommendationSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight * 0.72f),
                pagerState = pagerState,
                pages = viewModel.recommendedMoviesState
            ) {
                viewModel.navigateToDetailsScreen(it)
            }
        }
        if (viewModel.moviesFetchFlowState is FlowState.Loading)
            item{
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                    CircularProgressIndicator()
                }
            }
        else if (viewModel.moviesFetchFlowState is FlowState.Failure)
            item {
                Button(
                    onClick = { viewModel.goToPage(1) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Try Again", color = Color.White)
                }
            }
        if (viewModel.moviesState != null) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Movies List",
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(10.dp),
                )
            }
            items(items = viewModel.moviesState!!.results, key = { it.id }) {
                MovieItem(movie = it) {
                    viewModel.navigateToDetailsScreen(it)
                }
            }
        }
        item {
            PaginationSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                currentPage = viewModel.moviesState?.page,
            ) {
                viewModel.goToPage(it)
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }

}
