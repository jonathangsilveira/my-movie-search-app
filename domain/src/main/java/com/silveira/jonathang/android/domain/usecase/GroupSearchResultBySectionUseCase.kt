package com.silveira.jonathang.android.domain.usecase

import com.silveira.jonathang.android.domain.mapper.Mapper
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel
import kotlin.reflect.KClass

class GroupSearchResultBySectionUseCase(
    private val sectionMapper: Map<KClass<out SearchResultModel>, Mapper<List<SearchResultModel>, SearchSectionModel>>?
) {

    operator fun invoke(
        resultPageModel: SearchResultPageModel
    ) : List<SearchSectionModel> = resultPageModel.results
        .groupBy { it::class }
        .mapNotNull { entry ->
            sectionMapper?.getValue(entry.key)
                ?.map(entry.value)
        }
}