package com.example.yassirtest.ui.activities.main.sections.movie_item.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yassirtest.R
import com.example.yassirtest.domain.movies.entities.MovieEntity

@SuppressLint("DefaultLocale")
@Composable
fun MovieItemDetails(modifier: Modifier = Modifier, movieEntity: MovieEntity) {
    Text(
        text = movieEntity.title,
        color = MaterialTheme.colorScheme.onSurface,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = movieEntity.releaseDate,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f),
        fontSize = 14.sp
    )
    Row (
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = String.format("%.2f", movieEntity.voteAverage),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f),
            fontSize = 14.sp
        )
        Icon(
            painter = painterResource( id = R.drawable.baseline_star_24),
            contentDescription = null,
            tint = Color.Yellow,
            modifier = Modifier.size(18.dp)
        )
    }
}