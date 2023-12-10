package com.silveira.jonathang.android.domain.mapper

import com.silveira.jonathang.android.domain.model.MediaTypeEnum
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel

interface SearchSectionModelMappingStrategy<in T> : Mapper<T, SearchSectionModel?> {
    val mediaType: MediaTypeEnum
}

interface ItemsToSectionModelMappingStrategy :
    SearchSectionModelMappingStrategy<List<SearchResultModel>>