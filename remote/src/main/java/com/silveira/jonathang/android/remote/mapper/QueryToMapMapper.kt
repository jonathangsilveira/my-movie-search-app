package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.mapper.Mapper

internal const val QUERY = "query"
internal const val INCLUDE_ADULT = "include_adult"
internal const val LANGUAGE = "language"
internal const val PAGE = "page"

internal class QueryToMapMapper : Mapper<SearchQueryModel, Map<String, Any>> {
    override fun map(source: SearchQueryModel): Map<String, Any> {
        return with(source) {
            mapOf(
                QUERY to query,
                INCLUDE_ADULT to includeAdult,
                LANGUAGE to language,
                PAGE to page
            )
        }
    }
}