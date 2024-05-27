package com.example.yassirtest.ui.activities.details.sections.hero

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.yassirtest.domain.movies.entities.MovieEntity
import com.example.yassirtest.ui.activities.details.sections.hero.composables.BackdropImage
import com.example.yassirtest.ui.activities.details.sections.hero.composables.HeaderDetails

@Composable
fun HeroSection(modifier: Modifier = Modifier, movie : MovieEntity) {
    Box (
        modifier = modifier
    ) {
        BackdropImage(
            modifier = Modifier.fillMaxWidth(),
            backdropPath = movie.backdropPath ?: movie.posterPath
        )
        HeaderDetails(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            movie = movie
        )
    }
}