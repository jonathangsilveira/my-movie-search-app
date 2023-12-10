package com.silveira.jonathang.android.mymoviesearch.usecase

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

private const val DEBOUNCE_TIME_MILLIS = 500L

private const val MIN_QUERY_LENGTH = 3

@OptIn(FlowPreview::class)
internal class HandleDebounceQueryUseCase {
    private val queryState = MutableStateFlow("")

    fun observe(): Flow<String> =
        queryState.debounce(DEBOUNCE_TIME_MILLIS)
            .distinctUntilChanged()
            .filter { query -> query.trim().length >= MIN_QUERY_LENGTH }

    operator fun invoke(query: String) {
        queryState.value = query
    }
}