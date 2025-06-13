package econoshow.utils

/**
 * Used to determine overall app layout
 *
 * This functionality is not applied in the current version, since it was designed to operate exclusively on the
 * giant tablet for tradeshows, however should the need arise to have this app fit on phones or computers, this
 * enum should be used in the [com.example.econoshow.ui.EconoShowApp] composable function.
 */
enum class EconoShowContentType {
    LIST_ONLY,
    LIST_AND_DETAIL
}