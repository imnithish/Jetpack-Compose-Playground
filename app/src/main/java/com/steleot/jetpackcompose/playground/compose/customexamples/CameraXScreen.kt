package com.steleot.jetpackcompose.playground.compose.customexamples

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.compose.externallibraries.PermissionsAccompanistExample
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes
import timber.log.Timber

private const val Url = "customexamples/CameraXScreen.kt"

@Composable
fun CameraXScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.CameraX,
        link = Url,
    ) {
        CameraPreview()
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun CameraPreview(
    modifier: Modifier = Modifier,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
    scaleType: PreviewView.ScaleType = PreviewView.ScaleType.FILL_CENTER,
) {
    val context = LocalContext.current
    PermissionsAccompanistExample(
        navigateToSettingsScreen = {
            context.startActivity(
                Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
                )
            )
        }
    ) {
        AndroidCameraPreview(modifier, cameraSelector, scaleType)
    }
}

@Composable
private fun AndroidCameraPreview(
    modifier: Modifier = Modifier,
    cameraSelector: CameraSelector,
    scaleType: PreviewView.ScaleType,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    AndroidView(
        factory = { ctx ->
            val preview = PreviewView(ctx).apply {
                this.scaleType = scaleType
                layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                implementationMode = PreviewView.ImplementationMode.COMPATIBLE
            }
            val executor = ContextCompat.getMainExecutor(ctx)
            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()
                bindPreview(
                    lifecycleOwner,
                    preview,
                    cameraSelector,
                    cameraProvider,
                )
            }, executor)
            preview
        },
        modifier = modifier,
    )
}

private fun bindPreview(
    lifecycleOwner: LifecycleOwner,
    previewView: PreviewView,
    cameraSelector: CameraSelector,
    cameraProvider: ProcessCameraProvider,
) {
    val preview = Preview.Builder().build().also {
        it.setSurfaceProvider(previewView.surfaceProvider)
    }

    try {
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview
        )
    } catch (e: Exception) {
        Timber.e(e, "Camera x binding failed.")
    }
}
