//https://github.com/pratikksahu/JetPDFVue

package econoshow.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.pratikk.jetpdfvue.HorizontalVueReader
import com.pratikk.jetpdfvue.state.HorizontalVueReaderState
import kotlinx.coroutines.launch

/**
 * Displays a pdf
 *
 * Allows the viewing of a pdf file that moves left and right for multiple pages. This functionality is borrowed from <https://github.com/pratikksahu/JetPDFVue>
 *
 * @param modifier The [Modifier] applied to this component
 * @param horizontalVueReaderState The necessary logic to control the redrawing of a pdf when zooming, turning pages, or other controls.
 * @param import I don't know what this does, but it was in the sample. U•ェ•*U
 * @see JetPdfVue
 */
@Composable
fun HorizontalSampleA(
    modifier: Modifier = Modifier,
    horizontalVueReaderState: HorizontalVueReaderState,
    import:() -> Unit
) {
    Box(
        modifier = modifier
    ) {
        val scope = rememberCoroutineScope()
        val background = Modifier.background(MaterialTheme.colorScheme.background.copy(alpha = 0.75f),MaterialTheme.shapes.small)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.outline, shape = MaterialTheme.shapes.small)
            .clip(MaterialTheme.shapes.small)
        val iconTint = MaterialTheme.colorScheme.onBackground

        HorizontalVueReader(
            modifier = Modifier.fillMaxSize(),
            contentModifier = Modifier.fillMaxSize(),
            horizontalVueReaderState = horizontalVueReaderState
        )
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val showPrevious by remember {
                derivedStateOf { horizontalVueReaderState.currentPage != 1 }
            }
            val showNext by remember {
                derivedStateOf { horizontalVueReaderState.currentPage != horizontalVueReaderState.pdfPageCount }
            }
            if (showPrevious)
                IconButton(
                    modifier = background,
                    onClick = {
                        //Prev
                        scope.launch {
                            horizontalVueReaderState.prevPage()
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Previous",
                        tint = iconTint
                    )
                }
            else
                Spacer(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.Transparent)
                )
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            if (showNext)
                IconButton(
                    modifier = background,
                    onClick = {
                        //Next
                        scope.launch {
                            horizontalVueReaderState.nextPage()
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Next",
                        tint = iconTint
                    )
                }
            else
                Spacer(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.Transparent)
                )
        }
    }
}