package com.silveira.jonathang.android.presentation.compose.moviemedia

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silveira.jonathang.android.presentation.R.string.movie_poster_content_description
import com.silveira.jonathang.android.presentation.compose.mediaimage.MediaImage
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieMedia(
    name: String,
    popularity: Double,
    modifier: Modifier = Modifier,
    posterPath: String? = null,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.clickable { onClick() }
    ) {
        MediaImage(
            posterPath = posterPath,
            contentDescription = stringResource(movie_poster_content_description, name),
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
        )
        AssistChip(
            onClick = {  },
            label = {
                Text(text = popularity.toString())
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .wrapContentSize()
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            text = name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun MovieMediaPreview() {
    MyMovieSearchAppTheme {
        MovieMedia(
            name = "Terminator 2",
            popularity = 5.0,
            modifier = Modifier.wrapContentSize()
        )
    }
}