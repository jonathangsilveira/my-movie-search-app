package com.silveira.jonathang.android.presentation.compose.carousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silveira.jonathang.android.domain.model.MovieResultModel
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.presentation.compose.moviemedia.MovieMedia

@Composable
fun Carousel(
    modifier: Modifier = Modifier,
    content: LazyListScope.() -> Unit
) {
    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
        content = content
    )
}

@Preview
@Composable
fun CarouselPreview() {
    Carousel(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val movies = List(5) {
            val id = it.inc()
            MovieResultModel(
                id = id,
                title = "Movie #$id",
                popularity = 5.0,
                releaseDate = "1990",
                posterPath = "",
                originalLanguage = "en-US"
            )
        }
        items(
            items = movies,
            key = { item -> item.id },
            contentType = { item -> item.mediaType },
            itemContent = { item ->
                MovieMedia(
                    name = item.title,
                    popularity = item.popularity
                )
            }
        )
    }
}
