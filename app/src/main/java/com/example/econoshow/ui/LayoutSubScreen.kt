package com.example.econoshow.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.econoshow.R
import com.example.econoshow.model.Machine
import com.example.econoshow.ui.components.MissingContentMessage

@Composable
fun LayoutSubScreen(
    machine: Machine,
    modifier: Modifier = Modifier
) {
    if (machine.layouts.isEmpty()) {
        MissingContentMessage(
            message = R.string.no_layouts,
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
        )
        return
    }
}