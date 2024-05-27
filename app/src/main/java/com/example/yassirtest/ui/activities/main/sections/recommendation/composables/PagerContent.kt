package com.example.yassirtest.ui.activities.main.sections.recommendation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage
import com.example.yassirtest.domain.movies.entities.MovieEntity

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerContent(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pages: SnapshotStateList<MovieEntity>
) {
    HorizontalPager(state = pagerState, modifier = modifier) {
        val page = pages[it]
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            SubcomposeAsyncImage(
                model = page.posterPath,
                contentDescription = null,
                loading = {
                    CircularProgressIndicator()
                },
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize().align(Alignment.Center)
            )
        }
    }
}