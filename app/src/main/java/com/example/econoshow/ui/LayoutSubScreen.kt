package com.example.econoshow.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.econoshow.R
import com.example.econoshow.model.Layout
import com.example.econoshow.model.Machine
import com.example.econoshow.model.Video
import com.example.econoshow.ui.components.MissingContentMessage
import com.example.econoshow.utils.JetPdfVue
import com.example.econoshow.utils.VideoPlayer

@Composable
fun LayoutSubScreen(
    machine: Machine,
    modifier: Modifier = Modifier
) {
    var currentLayoutRes by remember { mutableStateOf(R.raw.layout_mini_mono_01) }
    var showLayout by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        if (machine.layouts.isEmpty()) {
            MissingContentMessage(
                message = R.string.no_layouts,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp)
            )
            return
        } else {
            LayoutThumbnailGrid(
                layouts = machine.layouts,
                onThumbnailClick = {
                    currentLayoutRes = it
                    showLayout = true
                },
                modifier = Modifier
                    .fillMaxSize(),
            )
            if (showLayout) {
                LayoutPopup(
                    layoutRes = currentLayoutRes,
                    onClose = {
                        showLayout = false
                    },
                    modifier = Modifier
                    //.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun LayoutThumbnailGrid(
    layouts: List<Layout>,
    onThumbnailClick: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(layouts) { layout ->
            LayoutThumbnailButton(
                layout = layout,
                onThumbnailClick = onThumbnailClick
            )
        }
    }
}

@Composable
private fun LayoutThumbnailButton(
    layout: Layout,
    onThumbnailClick: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {onThumbnailClick(layout.layoutRes)},
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(4.dp),
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
            disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
            disabledContentColor = MaterialTheme.colorScheme.onErrorContainer,
        ),
        modifier = modifier
    ) {
        Column {
            Image(
                painter = painterResource(layout.layoutThumbnailRes),
                contentDescription = stringResource(R.string.layout_thumbnail),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .height(360.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Text(
                text = stringResource(layout.titleRes),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
        }
    }
}

@Composable
fun LayoutPopup(
    layoutRes: Int,
    onClose: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface (
        color = MaterialTheme.colorScheme.scrim.copy(alpha = 0.33f),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Button(
                onClick = onClose,
//                colors = ButtonColors(
//                    containerColor = Color.Transparent,
//                    contentColor = Color.Transparent,
//                    disabledContainerColor = Color.Transparent,
//                    disabledContentColor = Color.Transparent,
//                ),
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button),
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.top_bar_height)),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Card (
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
                    disabledContentColor = MaterialTheme.colorScheme.onErrorContainer,
                ),
                modifier = Modifier
                    .weight(2f)
            ) {
                JetPdfVue(
                    pdfRes = layoutRes,
                    context = LocalContext.current,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Button(
                onClick = onClose,
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent,
                ),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) { }
        }
    }
}