package econoshow.ui

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
import com.example.econoshow.utils.JetPdfVue
import com.pratikk.jetpdfvue.HorizontalVueReader
import com.pratikk.jetpdfvue.state.VueFileType
import com.pratikk.jetpdfvue.state.VueLoadState
import com.pratikk.jetpdfvue.state.VueResourceType
import com.pratikk.jetpdfvue.state.rememberHorizontalVueReaderState
import com.pratikk.jetpdfvue.util.toFile

/**
 * The subscreen view for the [InformationScreen] that shows the selected [Machine]'s brochure
 *
 * @param machine The [Machine] to display the brochure of
 * @param modifier The [Modifier] applied to the component
 */
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

    JetPdfVue(
        pdfRes = machine.brochure,
        context = context,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
private fun BrochureSubScreenPreview() {
    BrochureSubScreen(
        machine = LocalEconoShowDataProvider.getCartonerMachineData().first()
    )
}