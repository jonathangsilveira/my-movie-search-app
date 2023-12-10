package com.silveira.jonathang.android.remote.repository

import com.silveira.jonathang.android.domain.datasource.SearchRemoteDataSource
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.domain.repository.SearchRepository

internal class SearchRepositoryImpl(
    private val remoteDataSource: SearchRemoteDataSource,
) : SearchRepository {

    override suspend fun search(
        query: SearchQueryModel
    ): SearchResultPageModel = remoteDataSource.search(query)
}