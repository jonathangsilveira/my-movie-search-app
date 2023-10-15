package com.silveira.jonathang.android.domain.datasource

import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel

interface SearchRemoteDataSource {
    suspend fun search(
        header: SearchHeaderModel,
        query: SearchQueryModel
    ): SearchResultPageModel
}