package com.example.yassirtest.ui.activities.details.sections.overview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun OverviewSection(modifier: Modifier = Modifier, overview: String) {
    Text(
        text = overview,
        color = MaterialTheme.colorScheme.onSurface,
        fontSize = 16.sp,
        modifier = modifier
    )
}