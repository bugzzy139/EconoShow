package com.example.econoshow.ui

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.econoshow.R
import com.example.econoshow.utils.VideoPlayer

@Composable
fun HomeScreen(
    onAnywhereClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        VideoPlayer(
            videoRes = R.raw.feature_collated,
            playWhenReady = true,
            loop = true,
            showControls = false,
            height = 1920,
            modifier = Modifier
                .fillMaxSize()
        )

        //Creates an infinite animation to bounce the padding value of the text up and down
        val infiniteTransition = rememberInfiniteTransition(label = "infinite")
        val paddingValue by infiniteTransition.animateValue(
            initialValue = 400.dp,
            targetValue = 420.dp,
            typeConverter = Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = EaseInOut),
                repeatMode = RepeatMode.Reverse
            ),
            label = "padding"
        )

        Text(
            text = stringResource(R.string.tap_to_start),
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = paddingValue)
        )
        Button(
            onClick = onAnywhereClick,
            shape = RectangleShape,
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxSize()
        ) { }
    }
}

@Preview(showBackground = true, heightDp = 1920, widthDp = 1080)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}