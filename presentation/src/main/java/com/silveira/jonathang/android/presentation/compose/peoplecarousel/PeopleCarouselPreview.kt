package com.silveira.jonathang.android.presentation.compose.peoplecarousel

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.silveira.jonathang.android.domain.model.PeopleSectionModel
import com.silveira.jonathang.android.domain.model.PersonResultModel
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "People Carousel Light"
)
@Composable
fun PeopleCarouselLightPreview() {
    val section = PeopleSectionModel(
        title = "People",
        items = List(5) {
            PersonResultModel(
                id = it,
                name = "Person #$it",
                popularity = 3.5,
                profilePath = "",
                knownForDepartment = "Acting",
                knownFor = emptyList()
            )
        }
    )
    MyMovieSearchAppTheme {
        PeopleCarousel(data = section)
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "People Carousel Dark"
)
@Composable
fun PeopleCarouselDarkPreview() {
    val section = PeopleSectionModel(
        title = "People",
        items = List(5) {
            PersonResultModel(
                id = it,
                name = "Person #$it",
                popularity = 3.5,
                profilePath = "",
                knownForDepartment = "Acting",
                knownFor = emptyList()
            )
        }
    )
    MyMovieSearchAppTheme {
        PeopleCarousel(data = section)
    }
}