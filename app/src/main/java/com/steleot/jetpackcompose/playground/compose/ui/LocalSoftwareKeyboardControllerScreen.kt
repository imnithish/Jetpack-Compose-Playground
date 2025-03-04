package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/LocalSoftwareKeyboardControllerScreen.kt"

@Composable
fun LocalSoftwareKeyboardControllerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalSoftwareKeyboardController,
        link = Url,
    ) {
        LocalSoftwareKeyboardControllerExample()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun LocalSoftwareKeyboardControllerExample() {
    val keyboardController = LocalSoftwareKeyboardController.current

    val focusRequester = FocusRequester()
    val (text, setText) = remember {
        mutableStateOf("Close keyboard on done ime action (blue ✔️)")
    }
    Column(Modifier.padding(16.dp)) {
        TextField(
            text,
            setText,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            ),
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                focusRequester.requestFocus()
                keyboardController?.show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show software keyboard.")
        }
    }
}