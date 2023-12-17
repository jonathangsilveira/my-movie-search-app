package com.silveira.jonathang.android.presentation.compose.mediaimage

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@Composable
fun MediaImage(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    posterPath: String? = null,
    contentDescription: String? = null
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://{base_url}/$posterPath")
            .crossfade(true)
            .size(Size.ORIGINAL)
            .build()
    )
    when (painter.state) {
        AsyncImagePainter.State.Empty -> PlaceholderMediaImage(
            icon = Icons.Default.Build,
            shape = shape,
            contentDescription = "Empty image",
            modifier = modifier
        )
        is AsyncImagePainter.State.Error -> {
            PlaceholderMediaImage(
                icon = Icons.Default.Warning,
                shape = shape,
                contentDescription = "Error image",
                modifier = modifier
            )
        }
        is AsyncImagePainter.State.Loading -> PlaceholderMediaImage(
            icon = Icons.Default.Refresh,
            shape = shape,
            contentDescription = "Loading image",
            modifier = modifier
        )
        is AsyncImagePainter.State.Success -> Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier.clip(shape)
        )
    }
}

@Composable
private fun PlaceholderMediaImage(
    icon: ImageVector,
    shape: Shape,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clip(shape)
    ) {
        Image(
            imageVector = icon,
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(
                color = Color.Black
            ),
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .background(color = Color.LightGray)
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MediaImageLightPreview() {
    MyMovieSearchAppTheme {
        MediaImage(
            modifier = Modifier.size(72.dp),
            contentDescription = "Image of Michael B. Jordan"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MediaImageDarkPreview() {
    MyMovieSearchAppTheme {
        MediaImage(
            modifier = Modifier.size(72.dp),
            contentDescription = "Image of Wesley Snipes"
        )
    }
}