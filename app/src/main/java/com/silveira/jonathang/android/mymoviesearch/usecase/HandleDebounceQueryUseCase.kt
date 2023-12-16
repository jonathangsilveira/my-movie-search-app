package com.silveira.jonathang.android.mymoviesearch.usecase

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

private const val DEBOUNCE_TIME_MILLIS = 500L

@OptIn(FlowPreview::class)
internal class HandleDebounceQueryUseCase {
    private val queryState = MutableStateFlow("")

    fun consume(minQueryLength: Int): Flow<String> =
        queryState.debounce(DEBOUNCE_TIME_MILLIS)
            .distinctUntilChanged()
            .map { query -> query.trim() }
            .filter { query -> query.length >= minQueryLength }

    operator fun invoke(query: String) {
        queryState.value = query
    }
}