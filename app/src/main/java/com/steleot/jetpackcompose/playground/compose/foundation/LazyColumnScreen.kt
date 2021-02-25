package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun LazyColumnScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyColumn.capitalize(Locale.getDefault())
    ) {

    }
}