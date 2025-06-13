package econoshow.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.example.econoshow.R

/**
 * Layout drawings for a [Machine]
 *
 * This is used in the [com.example.econoshow.data.LocalEconoShowDataProvider] data object to construct the necessary data for a machine
 *
 * @property id Identifier (currently unused)
 * @property titleRes The title of the layout
 * @property layoutRes The .pdf file of the layout
 * @property layoutThumbnailRes The image used as a thumbnail when creating a button to display the layout
 */
data class Layout (
    val id: Int,
    @StringRes val titleRes: Int = R.string.layout_title_default,
    @RawRes val layoutRes: Int,
    @DrawableRes val layoutThumbnailRes: Int = R.drawable.video_thumbnail_default,
)