package com.silveira.jonathang.android.presentation.compose.peoplecarousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.silveira.jonathang.android.domain.model.PeopleSectionModel
import com.silveira.jonathang.android.presentation.compose.personprofile.PersonProfile

@Composable
fun PeopleCarousel(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
    data: PeopleSectionModel
) {
    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
    ) {
        items(
            items = data.items,
            key = { person -> person.id },
        ) { person ->
            PersonProfile(
                name = person.name,
                tagText = person.knownForDepartment,
                profileImagePath = person.profilePath,
                modifier = Modifier.widthIn(min = 72.dp, max = 80.dp)
                    .wrapContentSize()
            )
        }
    }
}
