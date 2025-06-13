package econoshow.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.example.econoshow.R

/**
 * The information on a video file
 *
 * This is used in the [com.example.econoshow.data.LocalEconoShowDataProvider] data object to construct the necessary data for a machine
 *
 * @property id identifier (unused)
 * @property titleRes The title of the video
 * @property videoRes The video file of the video
 * @property thumbnailRes The thumbnail image used when creating the button
 */
data class Video(
    val id: Int,
    @StringRes val titleRes: Int = R.string.video_title_default,
    @RawRes val videoRes: Int,
    @DrawableRes val thumbnailRes: Int = R.drawable.video_thumbnail_default,
)
