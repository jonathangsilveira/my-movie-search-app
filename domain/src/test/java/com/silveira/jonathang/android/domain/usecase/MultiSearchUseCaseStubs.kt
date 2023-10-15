package com.silveira.jonathang.android.domain.usecase

import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel

internal object MultiSearchUseCaseStubs {
    val emptySearchResultPageModel = SearchResultPageModel(
        page = 0,
        totalPages = 0,
        totalResults = 0,
        results = emptyList()
    )

    val emptyHeaderModel = SearchHeaderModel(accept = "", accessToken = "")

    val emptyQueryModel = SearchQueryModel(
        query = "",
        page = 0,
        language = "",
        includeAdult = false
    )
}