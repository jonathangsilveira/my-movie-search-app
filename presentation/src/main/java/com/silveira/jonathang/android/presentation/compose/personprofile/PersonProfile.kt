package com.silveira.jonathang.android.presentation.compose.personprofile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.silveira.jonathang.android.presentation.compose.mediaposter.MediaImage
import com.silveira.jonathang.android.presentation.compose.tag.Tag

@Composable
fun PersonProfile(
    modifier: Modifier = Modifier,
    name: String,
    tagText: String,
    profileImagePath: String? = null,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        MediaImage(
            modifier = Modifier.width(72.dp).height(88.dp),
            contentDescription = "Image of $name"
        )
        Tag(
            modifier = Modifier.wrapContentSize(),
            label = tagText
        )
        Text(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            text = name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
