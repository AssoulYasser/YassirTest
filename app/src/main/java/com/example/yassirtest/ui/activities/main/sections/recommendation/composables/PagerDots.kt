package com.example.yassirtest.ui.activities.main.sections.recommendation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerDots(
    modifier : Modifier = Modifier,
    pagerState: PagerState
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(15.dp)) {
        repeat(times = pagerState.pageCount) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(10.dp)
                    .background(
                        color =
                            if(pagerState.currentPage == it)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.onSurface
                    )
            )
        }
    }
}