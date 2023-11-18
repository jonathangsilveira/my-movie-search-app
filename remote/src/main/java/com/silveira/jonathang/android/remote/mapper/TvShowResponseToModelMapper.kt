package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.mapper.Mapper
import com.silveira.jonathang.android.domain.model.PersonResultModel
import com.silveira.jonathang.android.domain.model.TvShowResultModel
import com.silveira.jonathang.android.remote.response.PersonResultResponse
import com.silveira.jonathang.android.remote.response.TvShowResultResponse

internal class TvShowResponseToModelMapper : Mapper<TvShowResultResponse, TvShowResultModel> {
    override fun map(
        source: TvShowResultResponse
    ): TvShowResultModel = with(source) {
        TvShowResultModel(
            id = id,
            name = name.orEmpty(),
            posterPath = posterPath.orEmpty(),
            popularity = popularity,
            originalLanguage = originalLanguage.orEmpty(),
            originCountry = originCountry,
            firstAirDate = firstAirDate
        )
    }
}