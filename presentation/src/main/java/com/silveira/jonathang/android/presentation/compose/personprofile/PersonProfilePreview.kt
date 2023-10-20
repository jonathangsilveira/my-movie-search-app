package com.silveira.jonathang.android.presentation.compose.personprofile

import android.content.res.Configuration
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PersonProfileLightPreview() {
    MyMovieSearchAppTheme {
        PersonProfile(
            modifier = Modifier.wrapContentSize(),
            name = "Michael B. Jordan",
            tagText = "Acting"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PersonProfileDarkPreview() {
    MyMovieSearchAppTheme {
        PersonProfile(
            modifier = Modifier.wrapContentSize(),
            name = "Wesley Snipes",
            tagText = "Acting"
        )
    }
}