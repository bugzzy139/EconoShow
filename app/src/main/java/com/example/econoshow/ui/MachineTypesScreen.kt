package com.example.econoshow.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.econoshow.R
import com.example.econoshow.data.LocalEconoShowDataProvider
import com.example.econoshow.model.MachineType
import com.example.econoshow.ui.components.PulloutCardList

@Composable
fun MachineTypesScreen(
    machineTypes: List<MachineType>,
    onMachineTypeButtonClicked: (MachineType) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column (
      modifier = modifier
    ) {
//        Spacer(
//            modifier = Modifier
//                .height(dimensionResource(R.dimen.top_bar_height))
//        )
        PulloutCardList(
            dataList = machineTypes,
            onClick = onMachineTypeButtonClicked,
            lazy = false,
            modifier = modifier
        )
        Text(
            text = "Choose your application",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .padding(top = 48.dp, start = 24.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 1080, heightDp = 1920)
@Composable
fun StartScreenPreview() {
    Surface {
        MachineTypesScreen(
            machineTypes = LocalEconoShowDataProvider.getMachineTypeData(),
            modifier = Modifier
                .fillMaxHeight()
        )
    }
}