package com.example.yassirtest.ui.activities.main.sections.recommendation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.yassirtest.domain.movies.entities.MovieEntity
import com.example.yassirtest.ui.activities.main.sections.recommendation.composables.Gradient
import com.example.yassirtest.ui.activities.main.sections.recommendation.composables.MovieButtons
import com.example.yassirtest.ui.activities.main.sections.recommendation.composables.PagerContent
import com.example.yassirtest.ui.activities.main.sections.recommendation.composables.PagerDots

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendationSection(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pages: SnapshotStateList<MovieEntity>,
    navigateToMovieDetail : (Int) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        PagerContent(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            pagerState = pagerState,
            pages = pages
        )
        Gradient()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(BiasAlignment(0f, 1f)),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MovieButtons(modifier = Modifier.fillMaxWidth()) {
                navigateToMovieDetail(pagerState.currentPage)
            }
            PagerDots(
                modifier = Modifier,
                pagerState = pagerState
            )
        }
    }
}