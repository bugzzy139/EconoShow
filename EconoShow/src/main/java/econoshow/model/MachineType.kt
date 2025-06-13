package econoshow.model

import androidx.annotation.StringRes

/**
 * The type of machine, e.g. Cartoner or Casepacker
 *
 * This is used in the [com.example.econoshow.data.LocalEconoShowDataProvider] data object to construct the necessary data for a machine
 *
 * @property id identifier (unused)
 * @property titleResourceId title of the type of machine
 * @property subtitleResourceId subtitle of the type of machine (unused)
 */
data class MachineType(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
)
