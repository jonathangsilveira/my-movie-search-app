package com.silveira.jonathang.android.presentation.compose.mediaimage

import android.content.res.Configuration
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@Composable
fun MediaImage(
    posterPath: String? = null,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    val semantics = Modifier.semantics {
        this.contentDescription = contentDescription.orEmpty()
    }
    Surface(
        modifier = modifier.then(semantics),
        color = MaterialTheme.colorScheme.onSurface,
        shape = MaterialTheme.shapes.small
    ) {}
}

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