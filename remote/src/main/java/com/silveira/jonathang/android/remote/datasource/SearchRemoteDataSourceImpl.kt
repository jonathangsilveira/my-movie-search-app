package com.silveira.jonathang.android.remote.datasource

import com.silveira.jonathang.android.remote.SearchService
import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.mapper.Mapper
import com.silveira.jonathang.android.domain.datasource.SearchRemoteDataSource
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.remote.response.SearchResponse

internal class SearchRemoteDataSourceImpl(
    private val searchService: SearchService,
    private val headerToMapMapper: Mapper<SearchHeaderModel, Map<String, String>>,
    private val queryToMapMapper: Mapper<SearchQueryModel, Map<String, String>>,
    private val responseToModelMapper: Mapper<SearchResponse, SearchResultPageModel>
) : SearchRemoteDataSource {

    override suspend fun search(
        header: SearchHeaderModel,
        query: SearchQueryModel
    ): SearchResultPageModel {
        val headerMap = headerToMapMapper.map(header)
        val queryMap = queryToMapMapper.map(query)
        return searchService.multiSearch(headerMap, queryMap)
            .let(responseToModelMapper::map)
    }
}