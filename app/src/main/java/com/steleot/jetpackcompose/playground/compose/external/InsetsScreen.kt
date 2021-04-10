package com.steleot.jetpackcompose.playground.compose.external

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.LocalWindowInsets
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "external/InsetsScreen.kt"

@Composable
fun InsetsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Insets.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InsetsExample()
        }
    }
}

@Composable
private fun InsetsExample() {
    val windowInsets = LocalWindowInsets.current
    val systemBarsInsets = windowInsets.systemBars.layoutInsets
    Text(
        text = """
        System bars insets:
        top: ${systemBarsInsets.top}
        left: ${systemBarsInsets.left}
        right: ${systemBarsInsets.right}
        bottom: ${systemBarsInsets.bottom}
        """.trimIndent()
    )
}