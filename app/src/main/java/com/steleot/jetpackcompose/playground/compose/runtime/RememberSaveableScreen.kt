package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes

private const val Url = "runtime/RememberSaveableScreen.kt"

@Composable
fun RememberSaveableScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.RememberSaveable,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Try orientation here")
            RememberSaveableExample()
        }
    }
}

@Composable
private fun RememberSaveableExample() {
    var count by rememberSaveable { mutableStateOf(0) }
    IntManipulateComponent(count) { value -> count = value }
}

@Composable
internal fun IntManipulateComponent(
    value: Int,
    setValue: (Int) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(
            onClick = { setValue(value - 1) }
        ) {
            Text(text = "Decrement")
        }
        Text(
            text = value.toString(),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { setValue(value + 1) }
        ) {
            Text(text = "Increment")
        }
    }
}
