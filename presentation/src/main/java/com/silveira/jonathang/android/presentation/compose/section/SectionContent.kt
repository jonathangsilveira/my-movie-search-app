package com.silveira.jonathang.android.presentation.compose.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silveira.jonathang.android.domain.model.MovieResultModel
import com.silveira.jonathang.android.presentation.compose.moviemedia.MovieMedia
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@Composable
fun SectionContent(
    modifier: Modifier = Modifier,
    title: String? = null,
    content: LazyListScope.() -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        title?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        vertical = 8.dp,
                        horizontal = 16.dp
                    )
            )
        }
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            content = content,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }
}

@Preview
@Composable
fun SectionContentPreview() {
    val movies = List(5) {
        val id = it.inc()
        MovieResultModel(
            id = id,
            name = "Movie #$id",
            popularity = 5.0,
            releaseDate = "1990",
            posterPath = "",
            originalLanguage = "en-US"
        )
    }
    MyMovieSearchAppTheme {
        SectionContent(
            title = "Section Title",
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                items = movies,
                key = { item -> item.id },
                contentType = { item -> item.type },
                itemContent = { item ->
                    MovieMedia(
                        name = item.name,
                        popularity = item.popularity
                    )
                }
            )
        }
    }
}