package com.silveira.jonathang.android.presentation.compose.mediaposter

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun MediaImage(
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    val semantics = Modifier.semantics {
        this.contentDescription = contentDescription.orEmpty()
    }
    Surface(
        modifier = modifier.then(semantics),
        color = MaterialTheme.colorScheme.onSurface,
        shape = MaterialTheme.shapes.small
    ) {}
}