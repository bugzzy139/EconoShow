package econoshow

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.example.econoshow.ui.EconoShowApp
import com.example.econoshow.ui.theme.EconoShowTheme
import com.example.econoshow.utils.AfkController

/**
 * Main entry point for the Android App.
 *
 * When the app launches, this is the first thing that is loaded and then procedes to act as the main and only
 * activity in this app. It opens up the [EconoShowApp] using [EconoShowTheme]. It also has a subscription to the
 * [onUserInteraction] event to keep track of user interaction. On a tap, it calls the [AfkController.resetTimer] method.
 */
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EconoShowTheme {
                val layoutDirection = LocalLayoutDirection.current
                Surface  (
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier
                        .padding(
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    EconoShowApp(windowSize = windowSize.widthSizeClass)
                }
            }
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        Log.d("INTERACTION", "Tap!")
        AfkController.resetTimer()
    }
}


@Preview(showBackground = true, name = "Compact")
@Composable
private fun EconoShowCompactPreview() {
    Surface {
        EconoShowApp(windowSize = WindowWidthSizeClass.Compact)
    }
}

@Preview(showBackground = true, name = "Medium", widthDp = 700)
@Composable
private fun EconoShowMediumPreview() {
    Surface {
        EconoShowApp(windowSize = WindowWidthSizeClass.Medium)
    }
}

@Preview(showBackground = true, name = "Expanded", widthDp = 1000)
@Composable
private fun EconoShowExpandedPreview() {
    Surface {
        EconoShowApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}

@Preview(showBackground = true, name = "Rockchip", widthDp = 1080, heightDp = 1920)
@Composable
private fun EconoShowRockchipPreview() {
    Surface {
        EconoShowApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}
