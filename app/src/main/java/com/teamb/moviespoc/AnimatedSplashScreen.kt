package com.teamb.moviespoc

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/*
*AnimatedSplashScreen
*
* Creator: Leoncio Chiunti
*/

@Composable
fun AnimatedSplashScreen() {
    val context = LocalContext.current
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) DARK_MODE else LIGHT_MODE,
        animationSpec = tween(
            durationMillis = SPLASH_DURATION.toInt()
        )
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(SPLASH_DURATION)
        Toast.makeText(context, SPLASH_ACTION_DUMMY_MESSAGE, Toast.LENGTH_SHORT).show()
    }
    Splash(alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(SPLASH_ICON_SIZE.dp)
                .alpha(alpha),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_splash),
            contentDescription = stringResource(id = R.string.splash_icon),
            tint = Color.Unspecified
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(alpha = DARK_MODE)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    Splash(alpha = DARK_MODE)
}

private const val DARK_MODE = 1f
private const val LIGHT_MODE = 0f
private const val SPLASH_ICON_SIZE = 250
private const val SPLASH_DURATION = 5000L
private const val SPLASH_ACTION_DUMMY_MESSAGE =
    "Home Screen" // TODO DELETE THIS VARIABLE WHEN AN ACTION PUT INSTEAD THE TOAST