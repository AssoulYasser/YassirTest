package com.example.yassirtest.ui.activities.details.sections.hero.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.yassirtest.domain.movies.entities.MovieEntity

@Composable
fun HeaderDetails(modifier: Modifier = Modifier, movie: MovieEntity) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SubcomposeAsyncImage(
            model = movie.posterPath,
            contentDescription = null,
            loading = {
                CircularProgressIndicator()
            },
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth(0.4f)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Details(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), movie = movie)
    }
}