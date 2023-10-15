package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.mapper.Mapper
import com.silveira.jonathang.android.domain.model.MovieResultModel
import com.silveira.jonathang.android.domain.model.PersonResultModel
import com.silveira.jonathang.android.domain.model.TvShowResultModel
import com.silveira.jonathang.android.remote.response.MovieResultResponse
import com.silveira.jonathang.android.remote.response.PersonResultResponse
import com.silveira.jonathang.android.remote.response.TvShowResultResponse

internal class MovieResponseToModelMapper : Mapper<MovieResultResponse, MovieResultModel> {
    override fun map(
        source: MovieResultResponse
    ): MovieResultModel = with(source) {
        MovieResultModel(
            id = id,
            name = name,
            posterPath = posterPath,
            popularity = popularity,
            originalLanguage = originalLanguage,
            releaseDate = releaseDate
        )
    }
}