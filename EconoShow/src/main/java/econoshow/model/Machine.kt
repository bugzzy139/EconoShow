package econoshow.model

import androidx.annotation.RawRes
import androidx.annotation.StringRes

/**
 * The data on a machine.
 *
 * This is used in the [com.example.econoshow.data.LocalEconoShowDataProvider] data object to construct the necessary data for a machine
 *
 * @property id identifier (unused)
 * @property name Name of the machine
 * @property brochure The Brochure .pdf file for the machine. May be empty.
 * @property videos The list of videos associated with the machine. May be empty.
 * @property layouts The list of layout .pdf files for the machine. May be empty.
 */
data class Machine(
    val id: Int,
    @StringRes val name: Int,
    @RawRes val brochure: Int? = null,
    val videos: List<Video> = listOf(),
    val layouts: List<Layout> = listOf(),
)
