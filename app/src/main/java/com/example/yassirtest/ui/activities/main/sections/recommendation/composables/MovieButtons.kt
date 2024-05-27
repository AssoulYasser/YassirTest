package com.example.yassirtest.ui.activities.main.sections.recommendation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yassirtest.R

@Composable
fun MovieButtons(modifier: Modifier = Modifier, navigateToDetail : () -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CostumeButton(
            backgroundColor = MaterialTheme.colorScheme.tertiary,
            onClick = { navigateToDetail() }
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = null,
                    tint = Color.White
                )
                Text(text = "Wish List")
            }
        }
        CostumeButton(
            backgroundColor = MaterialTheme.colorScheme.primary,
            onClick = { navigateToDetail() }
        ) {
            Text(text = "Details")
        }
    }
}

@Composable
private fun CostumeButton(
    onClick : () -> Unit,
    backgroundColor : Color,
    content : @Composable () -> Unit,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.White
        ),
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(60.dp)
            .width(160.dp)
    ) {
        content()
    }
}