package com.silveira.jonathang.android.remote.datasource

import com.silveira.jonathang.android.domain.datasource.SearchRemoteDataSource
import com.silveira.jonathang.android.domain.mapper.Mapper
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.remote.SearchService
import com.silveira.jonathang.android.remote.response.SearchResponse

internal class SearchRemoteDataSourceImpl(
    private val searchService: SearchService,
    private val queryToMapMapper: Mapper<SearchQueryModel, Map<String, String>>,
    private val responseToModelMapper: Mapper<SearchResponse, SearchResultPageModel>
) : SearchRemoteDataSource {

    override suspend fun search(
        query: SearchQueryModel
    ): SearchResultPageModel {
        val queryMap = queryToMapMapper.map(query)
        return searchService.multiSearch(queryMap)
            .let(responseToModelMapper::map)
    }
}