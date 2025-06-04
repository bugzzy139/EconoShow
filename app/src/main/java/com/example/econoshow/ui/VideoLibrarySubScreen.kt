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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.econoshow.R
import com.example.econoshow.data.LocalEconoShowDataProvider
import com.example.econoshow.model.Machine
import com.example.econoshow.model.Video
import com.example.econoshow.ui.components.MissingContentMessage
import com.example.econoshow.utils.VideoPlayer

@Composable
fun VideoLibrarySubScreen(
    machine: Machine,
    modifier: Modifier = Modifier
) {
    var currentVideoRes by remember { mutableStateOf(R.raw.youtube_mini_mono_01_1280x720_h264)}
    var showVideo by remember { mutableStateOf(false)}

    Box(
        modifier = modifier
    ) {
        if(machine.videos.isEmpty()) {
            MissingContentMessage(
                message = R.string.no_videos,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp)
            )
        } else {
            VideoThumbnailGrid(
                videos = machine.videos,
                onThumbnailClick = {
                    currentVideoRes = it
                    showVideo = true
                },
                modifier = Modifier
                    .fillMaxSize(),
            )
            if (showVideo) {
                VideoPopup(
                    videoRes = currentVideoRes,
                    onClose = {
                        showVideo = false
                    },
                    modifier = Modifier
                    //.align(Alignment.Center)
                )
            }
        }
    }
}

//region ThumbnailGrid

@Composable
fun VideoThumbnailGrid(
    videos: List<Video>,
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
        items(videos) { video ->
            VideoThumbnailButton(
                video = video,
                onThumbnailClick = onThumbnailClick
            )
        }
    }
}

@Composable
private fun VideoThumbnailButton(
    video: Video,
    onThumbnailClick: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {onThumbnailClick(video.videoRes)},
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
                painter = painterResource(video.thumbnailRes),
                contentDescription = stringResource(R.string.video_thumbnail),
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
                text = stringResource(video.titleRes),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
        }
    }
}

//endregion

@Composable
fun VideoPopup(
    videoRes: Int,
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
//            Button(
//                onClick = onClose,
//                colors = ButtonColors(
//                    containerColor = Color.Transparent,
//                    contentColor = Color.Transparent,
//                    disabledContainerColor = Color.Transparent,
//                    disabledContentColor = Color.Transparent,
//                ),
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxWidth()
//            ) { }
            Card (
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
                    disabledContentColor = MaterialTheme.colorScheme.onErrorContainer,
                )
            ) {
                VideoPlayer(
                    videoRes = videoRes,
                    modifier = Modifier
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

@Preview(showBackground = true)
@Composable
fun VideoThumbnailButtonPreview() {
    VideoThumbnailButton(
        video = LocalEconoShowDataProvider.getCartonerMachineData().first().videos.first(),
    )
}