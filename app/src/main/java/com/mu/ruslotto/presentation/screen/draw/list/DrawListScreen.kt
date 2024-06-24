package com.mu.ruslotto.presentation.screen.draw.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mu.ruslotto.R
import com.mu.ruslotto.presentation.components.AppTitle
import com.mu.ruslotto.presentation.screen.draw.item.DrawItemScreen

@SuppressLint("DefaultLocale")
@Composable
fun DrawListScreen(
    toUpdate: (id: Int) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppTitle(
            title = stringResource(R.string.draws_list),
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items((1..12).toList()) {
                DrawItemScreen(date = "01.${it.toString().padStart(2, '0')}.2023")
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 8.dp, bottom = 8.dp)
    ) {
        FloatingActionButton(
            modifier = Modifier.align(alignment = Alignment.BottomEnd),
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = CircleShape,
            onClick = { toUpdate(0) }
        ) {
            Icon(Icons.Filled.Add,null)
        }
    }

}