package econoshow.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.econoshow.R
import com.example.econoshow.model.Machine
import com.example.econoshow.model.MachineType

/**
 * Creates a list of cards
 *
 * This is used to create the buttons for [com.example.econoshow.ui.MachineTypesScreen] and [com.example.econoshow.ui.MachinesScreen].
 *
 * @param dataList The List of objects to create cards of
 * @param onClick The method that is called when a card is clicked
 * @param lazy Determines if the list should be a [LazyColumn] or a regular [Column]
 * @param modifier The [Modifier] applied to the component
 * @param contentPadding The padding around the content of the component
 */
@Composable
fun <T> PulloutCardList(
    dataList: List<T>,
    onClick: (T) -> Unit,
    lazy: Boolean = true,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    if (lazy) {
        LazyColumn (
            contentPadding = contentPadding,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            modifier = modifier
        ) {
            items(dataList) { data ->
                PulloutCardListItem(
                    data = data,
                    onItemClick = onClick
                )
            }
        }
    }
    else {
        Column {
            for (data in dataList) {
                PulloutCardListItem(
                    data = data,
                    onItemClick = onClick
                )
            }
        }
    }
}

@Composable
private fun <T> PulloutCardListItem(
    data: T,
    onItemClick: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    PulloutCard(
        data = data,
        onCardClick = onItemClick,
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(dimensionResource(R.dimen.button_height))
            .padding(vertical = dimensionResource(R.dimen.button_padding))
    )
}

@Composable
private fun <T> PulloutCard(
    data: T,
    onCardClick: (T) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card (
        elevation = CardDefaults.cardElevation(0.dp),
        onClick = { onCardClick(data) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Row (
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text =
                    when (data) {
                        is Machine -> stringResource(data.name)
                        is MachineType -> stringResource(data.titleResourceId)
                        else -> data.toString()
                    },
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(end = 32.dp)
            )
        }
    }
}

/**
 * Returns a message that lets the user know there is no content
 *
 * Used when a machine has no content for a sub screen, such as no videos, brochure, or layouts
 *
 * @param message The message to display
 * @param modifier The [Modifier] applied to the component
 */
@Composable
fun MissingContentMessage(
    @StringRes message: Int,
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Text(
            text = stringResource(message),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(
            modifier = Modifier
                .height(200.dp)
        )
        Text(
            text = " ＞︿＜\"",
            style = MaterialTheme.typography.displaySmall
        )
    }
}