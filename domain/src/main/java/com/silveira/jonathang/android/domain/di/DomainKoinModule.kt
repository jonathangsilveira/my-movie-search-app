package com.silveira.jonathang.android.domain.di

import com.silveira.jonathang.android.domain.mapper.ItemsToSectionModelMappingStrategy
import com.silveira.jonathang.android.domain.mapper.MoviesSectionModelMappingStrategy
import com.silveira.jonathang.android.domain.mapper.PeopleSectionModelMappingStrategy
import com.silveira.jonathang.android.domain.mapper.TvShowSectionModelMappingStrategy
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.MOVIE
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.PERSON
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.TV
import com.silveira.jonathang.android.domain.usecase.GroupSearchResultBySectionUseCase
import com.silveira.jonathang.android.domain.usecase.MultiSearchUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val domainKoinModule = module {
    factory {
        MultiSearchUseCase(repository = get())
    }

    factory {
        GroupSearchResultBySectionUseCase(
            mappingStrategies = listOf(
                get(named(PERSON)),
                get(named(TV)),
                get(named(MOVIE)),
            )
        )
    }

    factory(named(PERSON)) {
        PeopleSectionModelMappingStrategy()
    } bind ItemsToSectionModelMappingStrategy::class

    factory(named(TV)) {
        TvShowSectionModelMappingStrategy()
    } bind ItemsToSectionModelMappingStrategy::class

    factory(named(MOVIE)) {
        MoviesSectionModelMappingStrategy()
    } bind ItemsToSectionModelMappingStrategy::class
}