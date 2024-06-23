package com.mu.ruslotto.presentation.screen.draw

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mu.ruslotto.R

@Composable
fun DrawItemScreen(
    drawNumber: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 4.dp,
                    horizontal = 20.dp
                )
                .clickable {},
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.draw_number, drawNumber),
                color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_double_arrow),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}