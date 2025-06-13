package econoshow.utils

import android.content.Context
import androidx.annotation.RawRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.core.net.toUri
import com.pratikk.jetpdfvue.state.VueFileType
import com.pratikk.jetpdfvue.state.VueLoadState
import com.pratikk.jetpdfvue.state.VueResourceType
import com.pratikk.jetpdfvue.state.rememberHorizontalVueReaderState
import com.pratikk.jetpdfvue.util.toFile

/**
 * Displays a .PDF file
 *
 * Uses the jetpdfvue package ["org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"] & ["com.github.pratikksahu:JetPDFVue:1.0.7"] to display a .pdf file.
 * Also contains events that can be assigned functionality for the documented is loaded, imported, or errors.
 *
 * @param pdfRes The [RawRes] resource of the pdf file to be viewed
 * @param context The [Context] used to open the resource (context.resources.openRawResource())
 * @param modifier The [Modifier] applied to this component
 */
@Composable
fun JetPdfVue(
    @RawRes pdfRes: Int,
    context: Context,
    modifier: Modifier = Modifier
) {
    val horizontalVueReaderState = rememberHorizontalVueReaderState(
        resource = VueResourceType.Local(
            uri = context.resources.openRawResource(
                pdfRes
            ).toFile("pdf").toUri(),
            fileType = VueFileType.PDF
        ),
        cache = 3
    )

    val intSize = IntSize(1600, 2000)

    LaunchedEffect(Unit) {
        horizontalVueReaderState.load(
            context = context,
            coroutineScope = this,
            containerSize = intSize,
            isPortrait = true,
            customResource = null
        )
    }

    val vueLoadState = horizontalVueReaderState.vueLoadState
    when (vueLoadState) {
        is VueLoadState.DocumentError -> {
            /**
             * Handle Error by using
             * vueLoadState.getErrorMessage
             * */
        }

        VueLoadState.DocumentImporting -> {
            /**
             * Indicates when image/pdf is being imported
             * This is also the state when the image is done importing but is being processed
             * */
        }

        VueLoadState.DocumentLoaded -> {
            /**
             * This is the state where either
             * HorizontalPdfViewer(horizontalVueReaderState = horizontalVueReaderState)
             * or
             * VerticalPdfViewer(verticalVueReaderState = verticalVueReaderState)
             * Is used to display pdf
             * */
//            HorizontalVueReader(
//                modifier = Modifier
//                    .fillMaxSize(), // Modifier for pager
//                contentModifier = Modifier
//                    .fillMaxSize(), // Modifier for Individual page
//                horizontalVueReaderState = horizontalVueReaderState
//            )
            HorizontalSampleA(
                modifier = modifier,
                horizontalVueReaderState = horizontalVueReaderState
            ) { }
        }

        VueLoadState.DocumentLoading -> {
            /**
             * Indicates when image/pdf is loaded initially
             * This is also the state when resource type is custom
             * Use horizontalVueReaderState.loadPercent to get progress (Does not work with Custom resource)
             * */
        }

        VueLoadState.NoDocument -> {
            /**
             * This is the state where you want to create a new document
             * Here, show UI for ex, button to launch the import intent
             * */
        }
    }
}