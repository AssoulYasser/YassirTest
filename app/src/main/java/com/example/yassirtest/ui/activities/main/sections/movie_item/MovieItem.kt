package com.example.yassirtest.ui.activities.main.sections.movie_item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.yassirtest.domain.movies.entities.MovieEntity
import com.example.yassirtest.ui.activities.main.sections.movie_item.composables.MovieItemDetails
import com.example.yassirtest.ui.activities.main.sections.movie_item.composables.MoviePoster

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    movie: MovieEntity,
    navigateToMovieDetail : () -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MoviePoster(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(6.dp)),
            posterUrl = movie.posterPath
        )
        Column (
            modifier = Modifier.padding(end = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            MovieItemDetails(modifier = Modifier ,movieEntity = movie)
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navigateToMovieDetail() },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Details")
            }
        }
    }
}