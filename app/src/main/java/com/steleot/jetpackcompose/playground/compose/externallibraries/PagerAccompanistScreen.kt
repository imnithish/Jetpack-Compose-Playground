package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.util.*
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.*
import com.steleot.jetpackcompose.playground.*
import com.steleot.jetpackcompose.playground.compose.reusable.*
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import kotlin.math.*

private const val Url = "externallibraries/PagerAccompanistScreen.kt"

@Composable
fun PagerAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.PagerAccompanist,
        link = Url,
    ) {
        PagerExample()
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalCoilApi::class)
@Composable
private fun PagerExample() {
    val pagerState = rememberPagerState(pageCount = 10, initialOffscreenLimit = 2)
    Column(Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) { page ->
            Card(
                Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }

            ) {
                Box {
                    Image(
                        painter = rememberImagePainter(
                            data = randomSampleImageUrl(width = 600),
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .aspectRatio(1f)
                    )
                    ProfilePicture(
                        Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp)
                            .offset {
                                val pageOffset =
                                    this@HorizontalPager.calculateCurrentOffsetForPage(page)
                                IntOffset(
                                    x = (36.dp * pageOffset).roundToPx(),
                                    y = 0
                                )
                            }
                    )
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            indicatorShape = RoundedCornerShape(0.dp)
        )
    }
}

internal fun randomSampleImageUrl(
    seed: Int = (0..100000).random(),
    width: Int = 300,
    height: Int = width,
): String {
    return "https://picsum.photos/seed/$seed/$width/$height"
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun ProfilePicture(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(4.dp, MaterialTheme.colors.surface)
    ) {
        Image(
            painter = rememberImagePainter(
                data = randomSampleImageUrl(),
                builder = { crossfade(true) }),
            contentDescription = null,
            modifier = Modifier.size(72.dp)
        )
    }
}