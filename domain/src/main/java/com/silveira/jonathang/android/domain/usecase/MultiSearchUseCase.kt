package com.silveira.jonathang.android.domain.usecase

import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MultiSearchUseCase(
    private val repository: SearchRepository,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) {

    suspend operator fun invoke(
        header: SearchHeaderModel,
        query: SearchQueryModel
    ): Result<SearchResultPageModel> = withContext(coroutineContext) {
        runCatching { repository.search(header, query) }
    }
}