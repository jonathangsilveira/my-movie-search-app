package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.mapper.Mapper
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.remote.response.SearchResponse
import com.silveira.jonathang.android.remote.response.SearchResultResponse
import kotlin.reflect.KClass

internal typealias ResultItemKey = KClass<out SearchResultResponse>

internal typealias ResultItemValue = Mapper<SearchResultResponse, SearchResultModel>

internal class SearchResponseToModelMapper(
    private val resultItemToModelMapperMap: Map<ResultItemKey, ResultItemValue>?
) : Mapper<SearchResponse, SearchResultPageModel> {

    override fun map(
        source: SearchResponse
    ): SearchResultPageModel = with(source) {
        SearchResultPageModel(
            page = page,
            totalPages = totalPages,
            totalResults = totalResults,
            results = results.mapNotNull {
                resultItemToModelMapperMap?.getValue(it::class)?.map(it)
            }
        )
    }
}