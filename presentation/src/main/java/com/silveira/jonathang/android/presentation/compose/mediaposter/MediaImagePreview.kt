package com.silveira.jonathang.android.presentation.compose.mediaposter

import android.content.res.Configuration
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MediaImageLightPreview() {
    MyMovieSearchAppTheme {
        MediaImage(
            modifier = Modifier.wrapContentSize(),
            contentDescription = "Image of Michael B. Jordan"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MediaImageDarkPreview() {
    MyMovieSearchAppTheme {
        MediaImage(
            modifier = Modifier.wrapContentSize(),
            contentDescription = "Image of Wesley Snipes"
        )
    }
}