package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import kotlinx.coroutines.delay

private const val Url = "externallibraries/SwipeRefreshAccompanistScreen.kt"

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SwipeRefreshAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.SwipeRefreshAccompanist,
        link = Url,
    ) {
        var refreshing by remember { mutableStateOf(false) }
        LaunchedEffect(refreshing) {
            if (refreshing) {
                delay(2000)
                refreshing = false
            }
        }

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = refreshing),
            onRefresh = { refreshing = true },
            indicator = { state, trigger ->
                SwipeRefreshIndicator(
                    state = state,
                    refreshTriggerDistance = trigger,
                    scale = true,
                    arrowEnabled = false,
                    backgroundColor = MaterialTheme.colors.primary,
                    shape = MaterialTheme.shapes.small,
                    largeIndication = true,
                    elevation = 16.dp
                )
            },
        ) {
            LazyColumn {
                items(30) { index ->
                    Row(Modifier.padding(16.dp)) {
                        Image(
                            painter = rememberImagePainter(randomSampleImageUrl(index)),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                        )

                        Spacer(Modifier.width(8.dp))

                        Text(
                            text = "Text",
                            style = MaterialTheme.typography.subtitle2,
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}