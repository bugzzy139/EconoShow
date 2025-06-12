package com.example.econoshow.utils

import android.util.TypedValue
import androidx.annotation.RawRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.pratikk.jetpdfvue.util.toFile

/**
 * Creates an ExoPlayer composable that plays a video with a Resource Index [videoRes].
 * Specify if you want it start automatically with [playWhenReady] and declare its height with [height].
 * Use [loop] to specify if the video should loop infinitely. [showControls] is used to determine if video controls are enabled.
 */
@Composable
fun VideoPlayer(
    @RawRes videoRes: Int,
    playWhenReady: Boolean = true,
    loop: Boolean = false,
    showControls: Boolean = true,
    height: Int = 720,
    modifier: Modifier = Modifier
) {
    //Get the current context
    val context = LocalContext.current

    //Initialize ExoPlayer
    val exoPlayer = ExoPlayer.Builder(context).build()

    //Get file extension
    var value = TypedValue()
    context.resources.getValue(videoRes, value, true)
    val resPath = value.string.toString()

    val regex = Regex("[.]\\w{3}", RegexOption.IGNORE_CASE)
    val matchResult = regex.find(resPath)
    val extension = matchResult.toString()

    val uri = context.resources.openRawResource(videoRes)
        .toFile(extension).toUri()

    //Create a MediaSource
    val mediaSource = remember(uri) {
        MediaItem.fromUri(uri)
    }

    //Set MediaSource to ExoPlayer
    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = playWhenReady
        exoPlayer.repeatMode = if (loop) ExoPlayer.REPEAT_MODE_ONE else ExoPlayer.REPEAT_MODE_OFF
    }

    //Manage lifecycle events
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    //Use AndroidView to embed an Android View (PlayerView) into Compose
    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
                useController = showControls
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
    )

//    val mediaItem = MediaItem.fromUri(uri)
//
//    player.setMediaItem(mediaItem)
//
//    player.repeatMode = ExoPlayer.REPEAT_MODE_OFF
//    player.prepare()
//    player.playWhenReady = true
}