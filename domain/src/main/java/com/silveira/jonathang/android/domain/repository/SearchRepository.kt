package com.silveira.jonathang.android.domain.repository

import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel

interface SearchRepository {
    suspend fun search(
        header: SearchHeaderModel,
        query: SearchQueryModel
    ) : SearchResultPageModel
}