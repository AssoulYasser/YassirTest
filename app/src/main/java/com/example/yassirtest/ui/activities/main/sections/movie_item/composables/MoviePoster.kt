package com.example.yassirtest.ui.activities.main.sections.movie_item.composables

import androidx.compose.foundation.background
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage

@Composable
fun MoviePoster(modifier: Modifier = Modifier, posterUrl: String) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = posterUrl,
        contentDescription = null,
        loading = {
            CircularProgressIndicator()
        },
        contentScale = ContentScale.FillWidth,
    )
}