package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.mapper.Mapper

internal const val QUERY = "query"
internal const val INCLUDE_ADULT = "include_adult"
internal const val LANGUAGE = "language"
internal const val PAGE = "page"

internal class QueryToMapMapper : Mapper<SearchQueryModel, Map<String, String>> {
    override fun map(source: SearchQueryModel): Map<String, String> {
        return with(source) {
            mapOf(
                QUERY to query,
                INCLUDE_ADULT to includeAdult.toString(),
                LANGUAGE to language,
                PAGE to page.toString()
            )
        }
    }
}