package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.AnimationNavRoutes

private const val Url = "animation/AnimateEnterExitScreen.kt"

@Composable
fun AnimateEnterExitScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.AnimateEnterExit,
        link = Url,
    ) {
        var visible by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    visible = !visible
                },
            ) {
                Text(text = "Press me to ${if (visible) "hide" else "show"}")
            }
            AnimateEnterExit(visible)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimateEnterExit(
    visible: Boolean,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(
            animationSpec = tween(
                500,
                delayMillis = 250,
                easing = LinearOutSlowInEasing
            )
        ),
        exit = fadeOut()
    ) {
        Box(
            Modifier
                .background(MaterialTheme.colors.primary)
                .padding(64.dp)
        ) {
            Box(
                Modifier
                    .align(Alignment.TopStart)
                    .animateEnterExit(
                        enter = slideInVertically(),
                        exit = slideOutVertically()
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .requiredHeight(100.dp)
                    .background(MaterialTheme.colors.secondary)
            ) {
                Text(
                    text = "Jetpack Compose Playground",
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}