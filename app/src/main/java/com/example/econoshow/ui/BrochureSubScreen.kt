package com.example.econoshow.ui

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.econoshow.R
import com.example.econoshow.data.LocalEconoShowDataProvider
import com.example.econoshow.model.Machine
import com.example.econoshow.ui.components.MissingContentMessage
import com.example.econoshow.utils.HorizontalSampleA
import com.pratikk.jetpdfvue.HorizontalVueReader
import com.pratikk.jetpdfvue.state.VueFileType
import com.pratikk.jetpdfvue.state.VueLoadState
import com.pratikk.jetpdfvue.state.VueResourceType
import com.pratikk.jetpdfvue.state.rememberHorizontalVueReaderState
import com.pratikk.jetpdfvue.util.toFile

@Composable
fun BrochureSubScreen(
    machine: Machine,
    modifier: Modifier = Modifier
) {
    if (machine.brochure == null) {
        MissingContentMessage(
            message = R.string.no_brochure,
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
        )
        return
    }

    val context = LocalContext.current

    val horizontalVueReaderState = rememberHorizontalVueReaderState(
        resource = VueResourceType.Local(
            uri = context.resources.openRawResource(
                machine.brochure
            ).toFile("pdf").toUri(),
            fileType = VueFileType.PDF
        ),
        cache = 3
    )

    val intSize = IntSize(800, 1000)

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
    when(vueLoadState){
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
                modifier = Modifier.fillMaxSize(),
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

@Preview
@Composable
fun BrochureSubScreenPreview() {
    BrochureSubScreen(
        machine = LocalEconoShowDataProvider.getCartonerMachineData().first()
    )
}