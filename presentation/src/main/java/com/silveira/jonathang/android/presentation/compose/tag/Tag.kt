package com.silveira.jonathang.android.presentation.compose.tag

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    label: String
) {
    Surface(
        modifier = modifier,
        shape = CircleShape
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(
    name = "Tag Light",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun TagLightPreview() {
    MyMovieSearchAppTheme {
        Tag(label = "Acting")
    }
}

@Preview(
    name = "Tag Dark",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun TagDarkPreview() {
    MyMovieSearchAppTheme {
        Tag(label = "Acting")
    }
}