package com.example.econoshow

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
fun EconoShowCompactPreview() {
    Surface {
        EconoShowApp(windowSize = WindowWidthSizeClass.Compact)
    }
}

@Preview(showBackground = true, name = "Medium", widthDp = 700)
@Composable
fun EconoShowMediumPreview() {
    Surface {
        EconoShowApp(windowSize = WindowWidthSizeClass.Medium)
    }
}

@Preview(showBackground = true, name = "Expanded", widthDp = 1000)
@Composable
fun EconoShowExpandedPreview() {
    Surface {
        EconoShowApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}

@Preview(showBackground = true, name = "Rockchip", widthDp = 1080, heightDp = 1920)
@Composable
fun EconoShowRockchipPreview() {
    Surface {
        EconoShowApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}
