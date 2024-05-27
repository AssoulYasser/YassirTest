package com.example.yassirtest.ui.activities.details.sections.hero.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yassirtest.R
import com.example.yassirtest.domain.movies.entities.MovieEntity

@Composable
fun Details(modifier: Modifier = Modifier, movie: MovieEntity) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Data(modifier = Modifier.fillMaxWidth(), movie = movie)
        Spacer(modifier = Modifier.height(20.dp))
        Actions(modifier = Modifier.fillMaxWidth(), movie = movie)
    }
}

@Composable
private fun Data(modifier: Modifier = Modifier, movie: MovieEntity) {
    Text(
        text = movie.originalTitle,
        color = Color.White,
        fontWeight = FontWeight.Black,
        fontSize = 20.sp
    )
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DetailText(text = movie.releaseDate)
        Dot()
        DetailText(text = movie.originalLanguage.uppercase())
    }
}

@SuppressLint("DefaultLocale")
@Composable
private fun Actions(modifier: Modifier = Modifier, movie: MovieEntity) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_thumb_up_24),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = String.format("%.0f", movie.voteCount * (movie.voteAverage) / 10),
                color = Color.White
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_thumb_down_24),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = String.format("%.0f", movie.voteCount * (10 - movie.voteAverage) / 10),
                color = Color.White
            )
        }
    }
}

@Composable
private fun Dot() {
    Box(modifier = Modifier
        .clip(CircleShape)
        .size(8.dp)
        .background(color = Color.White.copy(alpha = 0.8f)))
}

@Composable
private fun DetailText(text : String) {
    Text(
        text = text,
        color = Color.White.copy(alpha = 0.8f),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        textAlign = TextAlign.Start
    )
}