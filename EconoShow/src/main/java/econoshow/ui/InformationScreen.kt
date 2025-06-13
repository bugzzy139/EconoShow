package econoshow.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.econoshow.data.LocalEconoShowDataProvider
import com.example.econoshow.model.Machine

/**
 * Displays all the information on a [Machine]
 *
 * This will hold the necessary navigation elements as well as control the logic of which additional screen to display:
 * [BrochureSubScreen], [VideoLibrarySubScreen], & [LayoutSubScreen]
 *
 * @param machine The [Machine] to display the information of
 * @param subScreenIndex The index that controls which subscreen to display
 * @param onSegmentedButtonClick The method that controls what happens in the segmented button, used to change the subscreen
 * @param modifier The [Modifier] applied to the component
 */
@Composable
fun InformationScreen(
    machine: Machine,
    subScreenIndex: Int = 0,
    onSegmentedButtonClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(machine.name),
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .padding(top = 40.dp)
        )

        val options = listOf("Brochure", "Videos", "Layout")
        SingleChoiceSegmentedButtonRow (
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
        ) {
            options.forEachIndexed{ index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    onClick = {onSegmentedButtonClick(index)},
                    selected = index == subScreenIndex,
                    modifier = Modifier
                        .height(100.dp)
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.displayMedium
                    )
                }
            }
        }

        when(subScreenIndex) {
            0 -> BrochureSubScreen(
                machine = machine,
                modifier = Modifier
                    .fillMaxSize()
            )
            1 -> VideoLibrarySubScreen(
                machine = machine,
                modifier = Modifier
                    .fillMaxSize()
            )
            2 -> LayoutSubScreen(
                machine = machine,
                modifier = Modifier
                    .fillMaxSize()
            )
            else -> Text("Something went wrong ＞︿＜ \n Please restart the machine and try again.")
        }
    }
}

@Preview(showBackground = true, name = "Rockchip", widthDp = 1080, heightDp = 1920)
@Composable
private fun InformationScreenPreview() {
    InformationScreen(
        machine = LocalEconoShowDataProvider.getCartonerMachineData().first(),
        onSegmentedButtonClick = {},
        modifier = Modifier.fillMaxSize()
    )
}