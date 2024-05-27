package com.example.yassirtest.ui.activities.main.sections.recommendation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun BoxScope.Gradient() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .background(
                brush = Brush.verticalGradient(
                    startY = 200f,
                    endY = 100f,
                    colors = listOf(
                        MaterialTheme.colorScheme.secondary,
                        Color.Transparent
                    )
                )
            )
            .align(Alignment.BottomCenter)
    )
}