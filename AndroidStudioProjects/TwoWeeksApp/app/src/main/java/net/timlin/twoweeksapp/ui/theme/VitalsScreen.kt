package net.timlin.twoweeksapp.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import net.timlin.twoweeksapp.R
import net.timlin.twoweeksapp.data.local.DataSource
import net.timlin.twoweeksapp.model.DayTip
import net.timlin.twoweeksapp.model.TwoWeekViewModel
import net.timlin.twoweeksapp.model.TwoWeeksUiState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun VitalsReleaseApp(
    vitalReleaseViewModel:TwoWeekViewModel  = viewModel(
        factory = TwoWeekViewModel.Factory
    )
) {
    DayTipList("Test")
    MyTopBar(false,
        uiState = vitalReleaseViewModel.uiState.collectAsState().value,
        selectLayout = vitalReleaseViewModel::selectLayout
    )

}
@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(isLinearLayout:Boolean, selectLayout: (Boolean) -> Unit, uiState: TwoWeeksUiState)
{

    TopAppBar(
        title = { Text(stringResource(R.string.top_bar_name)) },
        actions = {

            IconButton(
                onClick = {

                    selectLayout(!isLinearLayout)
                }
            ) {

                Icon(
                    painter = painterResource(uiState.toggleIcon),
                    contentDescription = stringResource(uiState.toggleContentDescription),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }

        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary
        )

    )

}


@Composable
fun DayTipList(name: String, modifier: Modifier = Modifier) {
    Spacer(modifier= Modifier.padding(24.dp))
    LazyColumn(
        modifier = modifier

    ) {
        items(DataSource.dayTips) { dayTip ->
            DayTipCard(dayTip)
        }
    }
}
@Composable
fun DayTipCard(dayTip: DayTip, modifier: Modifier = Modifier) {
    var expanded:Boolean by remember { mutableStateOf(false) }
    Card(modifier=Modifier.padding(16.dp).clickable { expanded = !expanded },
        shape = RoundedCornerShape(24.dp)) {
        Row() {
            Text(text = stringResource(dayTip.label),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom =8.dp))
        }
        Row() {
            Image(
                painter = painterResource(dayTip.imageResourceId), contentDescription = null,
                modifier
            )
        }

        AnimatedVisibility(visible = expanded) {
            Column(modifier = Modifier.padding(start = 16.dp, top = 4.dp)) {
                Text(text = stringResource(dayTip.tips),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom =8.dp))
            }
        }
    }
}