package com.example.yassirtest.ui.activities.main.sections.pagination

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun PaginationSection(modifier: Modifier, currentPage: Int?, changePage : (Int) -> Unit) {
    Box(modifier = modifier) {
        PrevButton(modifier = Modifier.align(Alignment.CenterStart), isDisabled = currentPage == 1) {
            if (currentPage != null) {
                changePage(currentPage - 1)
            }
        }
        Text(
            text = currentPage.toString(),
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Black,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Center)
        )
        NextButton(modifier = Modifier.align(Alignment.CenterEnd), isDisabled = currentPage == 500) {
            if (currentPage != null) {
                changePage(currentPage + 1)
            }
        }
    }
}

@Composable
private fun NextButton(modifier : Modifier, isDisabled : Boolean, onClick: () -> Unit) {
    NextPrevButton(onClick = onClick, enabled = !isDisabled, modifier = modifier) {
        Text(text = "Next >", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
private fun PrevButton(modifier : Modifier, isDisabled : Boolean, onClick: () -> Unit) {
    NextPrevButton(onClick = onClick, enabled = !isDisabled, modifier = modifier) {
        Text(text = "< Prev", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
private fun NextPrevButton(
    modifier : Modifier,
    enabled : Boolean,
    onClick : () -> Unit,
    Content : @Composable () -> Unit
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            disabledContainerColor = Color.Transparent
        ),
        modifier = modifier
    ) {
        Content()
    }
}