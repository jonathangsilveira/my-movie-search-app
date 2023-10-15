package com.silveira.jonathang.android.remote.repository

import com.silveira.jonathang.android.domain.datasource.SearchRemoteDataSource
import com.silveira.jonathang.android.domain.repository.SearchRepository
import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel

class SearchRepositoryImpl(
    private val remoteDataSource: SearchRemoteDataSource,
) : SearchRepository {

    override suspend fun search(
        header: SearchHeaderModel,
        query: SearchQueryModel
    ): SearchResultPageModel = remoteDataSource.search(header, query)
}