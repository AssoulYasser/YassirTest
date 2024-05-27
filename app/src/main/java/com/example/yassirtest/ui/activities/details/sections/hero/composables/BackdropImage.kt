package com.example.yassirtest.ui.activities.details.sections.hero.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage

@Composable
fun BackdropImage(modifier: Modifier = Modifier, backdropPath: String?) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = backdropPath,
        contentDescription = null,
        loading = {
            CircularProgressIndicator()
        },
        contentScale = ContentScale.Crop,
    )
    Box(modifier = Modifier.fillMaxSize().background(color = Color.Black.copy(alpha = 0.75f)))
}