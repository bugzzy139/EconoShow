package econoshow.utils

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
 *
 * This was made to the app's goal of playing videos offline, as tradeshows don't necessarily have reliable internet access.
 * The current implementation of this method allows the playing of videos that use .mp4 or .mov extensions (technically, it's
 * any extension with three word characters).
 *
 * There is a bug where a video that is too high quality bitrate causes the video player to crash the app. I'm not sure why this is,
 * but using a lower bitrate seems to help with app reliability. I recommend using [Cobalt](<https://cobalt.tools/>) to download videos
 * from the web and convert them into a file that can be used in the app.
 *
 * @param videoRes The [RawRes] resource of the video file to be played.
 * @param playWhenReady Should the video play immediately when it's ready?
 * @param loop Should the video loop indefinitely?
 * @param showControls Should controls be available to the user?
 * @param height The height of the video player
 * @param modifier The [Modifier] to be applied to this component
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