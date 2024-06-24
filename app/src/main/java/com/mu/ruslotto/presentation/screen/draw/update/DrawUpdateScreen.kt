package com.mu.ruslotto.presentation.screen.draw.update

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mu.ruslotto.R
import com.mu.ruslotto.presentation.components.AppTitle
import com.mu.ruslotto.presentation.components.OkAndCancel

@Composable
fun DrawUpdateScreen(
    toDrawList: () -> Unit
) {
    Column {
        AppTitle(title = "update")
        OkAndCancel(
            titleOk = stringResource(id = R.string.save),
            onOK = { /*TODO*/ },
            onCancel = { toDrawList() }
        )
    }
}