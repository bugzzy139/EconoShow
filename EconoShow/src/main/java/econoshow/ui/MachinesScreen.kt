package econoshow.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.econoshow.data.LocalEconoShowDataProvider
import com.example.econoshow.model.Machine
import com.example.econoshow.model.MachineType
import com.example.econoshow.ui.components.PulloutCardList
/**
 * Shows the different [Machine]s in the [com.example.econoshow.data.LocalEconoShowDataProvider]
 *
 * @param machines The different [Machine]s to display
 * @param onMachineButtonClicked The callback for when a button is clicked. Returns the [Machine]
 * @param modifier The [Modifier] applied to the component
 */
@Composable
fun MachinesScreen(
    machines: List<Machine>,
    onMachineButtonClicked: (Machine) -> Unit = {},
    modifier: Modifier = Modifier
) {
    PulloutCardList(
        dataList = machines,
        onClick = onMachineButtonClicked,
        modifier = modifier,
    )
}

@Preview(showBackground = true, heightDp = 1920, widthDp = 1080)
@Composable
private fun MachinesScreenPreview() {
    MachinesScreen(
        machines = LocalEconoShowDataProvider.getCartonerMachineData(),
        modifier = Modifier.fillMaxHeight()
    )
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun MachinesScreenCompactPreview() {
    MachinesScreen(
        machines = LocalEconoShowDataProvider.getCartonerMachineData(),
        modifier = Modifier.fillMaxHeight()
    )
}