package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.AnimationNavRoutes

private const val Url = "animation/RotateAnimationScreen.kt"

@Composable
fun RotateAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.RotateAnimation,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RotateAnimationExample()
        }
    }
}

@Composable
private fun RotateAnimationExample() {
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.Center)
        ) {
            rotate(rotation) {
                drawRect(Color.Red, size = size)
            }
        }
    }
}
