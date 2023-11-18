package com.silveira.jonathang.android.domain.usecase

import com.silveira.jonathang.android.domain.mapper.ItemsToSectionModelMappingStrategy
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel

class GroupSearchResultBySectionUseCase(
    private val mappingStrategies: List<ItemsToSectionModelMappingStrategy>
) {
    private val mappingStrategiesMap by lazy {
        mappingStrategies.associateBy { it.mediaType }
    }

    operator fun invoke(
        resultPageModel: SearchResultPageModel
    ) : Result<List<SearchSectionModel>> = runCatching {
        resultPageModel.results
            .groupBy { it.mediaType }
            .mapNotNull { (key, value) -> mappingStrategiesMap[key]?.map(value) }
    }
}