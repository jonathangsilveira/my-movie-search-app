package com.silveira.jonathang.android.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silveira.jonathang.android.domain.model.MediaTypeEnum
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.MOVIE
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.PERSON
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.TV
import com.silveira.jonathang.android.domain.model.MovieResultModel
import com.silveira.jonathang.android.domain.model.MoviesSectionModel
import com.silveira.jonathang.android.domain.model.PeopleSectionModel
import com.silveira.jonathang.android.domain.model.PersonResultModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel
import com.silveira.jonathang.android.domain.model.TvShowsSectionModel
import com.silveira.jonathang.android.presentation.compose.moviemedia.MovieMedia
import com.silveira.jonathang.android.presentation.compose.personprofile.PersonProfile
import com.silveira.jonathang.android.presentation.compose.section.SectionContent
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@Composable
fun SearchResultsContent(
    sections: List<SearchSectionModel>,
    modifier: Modifier = Modifier,
    onItemClick: (MediaTypeEnum, Int) -> Unit = { _, _ -> }
) {
    LazyColumn(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(
            items = sections,
            key = { section -> section.mediaType },
            contentType = { section -> section.mediaType },
            itemContent = { section ->
                when (section.mediaType) {
                    PERSON -> PeopleSectionContent(
                        data = section as PeopleSectionModel,
                        modifier = Modifier.wrapContentSize(),
                        onItemClick = onItemClick
                    )

                    TV -> MoviesSectionContent(
                        data = section as MoviesSectionModel,
                        modifier = Modifier.wrapContentSize(),
                        onItemClick = onItemClick
                    )

                    MOVIE -> TvShowsSectionContent(
                        data = section as TvShowsSectionModel,
                        modifier = Modifier.wrapContentSize(),
                        onItemClick = onItemClick
                    )
                }
            }
        )
    }
}

@Composable
internal fun PeopleSectionContent(
    data: PeopleSectionModel,
    modifier: Modifier = Modifier,
    onItemClick: (MediaTypeEnum, Int) -> Unit = { _, _ -> }
) {
    SectionContent(
        title = data.title,
        modifier = modifier
    ) {
        items(
            items = data.items,
            key = { item -> item.id },
            contentType = { item -> item.mediaType },
            itemContent = { item ->
                PersonProfile(
                    name = item.name,
                    tagText = item.knownForDepartment,
                    profileImagePath = item.profilePath,
                    modifier = Modifier.wrapContentSize(),
                    onClick = {
                        onItemClick(item.mediaType, item.id)
                    }
                )
            }
        )
    }
}

@Composable
internal fun MoviesSectionContent(
    data: MoviesSectionModel,
    modifier: Modifier = Modifier,
    onItemClick: (MediaTypeEnum, Int) -> Unit = { _, _ -> }
) {
    SectionContent(
        title = data.title,
        modifier = modifier
    ) {
        items(
            items = data.items,
            key = { item -> item.id },
            contentType = { item -> item.mediaType },
            itemContent = { item ->
                MovieMedia(
                    name = item.title,
                    popularity = item.popularity,
                    posterPath = item.posterPath,
                    modifier = Modifier.wrapContentSize(),
                    onClick = { onItemClick(item.mediaType, item.id) }
                )
            }
        )
    }
}

@Composable
internal fun TvShowsSectionContent(
    data: TvShowsSectionModel,
    modifier: Modifier = Modifier,
    onItemClick: (MediaTypeEnum, Int) -> Unit = { _, _ -> }
) {
    SectionContent(
        title = data.title,
        modifier = modifier
    ) {
        items(
            items = data.items,
            key = { item -> item.id },
            contentType = { item -> item.mediaType },
            itemContent = { item ->
                MovieMedia(
                    name = item.name,
                    popularity = item.popularity,
                    posterPath = item.posterPath,
                    modifier = Modifier.wrapContentSize(),
                    onClick = { onItemClick(item.mediaType, item.id) }
                )
            }
        )
    }
}

@Preview
@Composable
fun SearchResultsContentPreview() {
    val sections = listOf(
        MoviesSectionModel(
            title = "Movies",
            items = List(5) {
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
        ),
        PeopleSectionModel(
            title = "People",
            items = List(5) {
                val id = it.inc()
                PersonResultModel(
                    id = id,
                    name = "Person #$id",
                    popularity = 5.0,
                    knownForDepartment = "Acting",
                    knownFor = emptyList(),
                    profilePath = ""
                )
            }
        )
    )
    MyMovieSearchAppTheme {
        SearchResultsContent(
            sections = sections,
            modifier = Modifier.fillMaxSize()
        )
    }
}