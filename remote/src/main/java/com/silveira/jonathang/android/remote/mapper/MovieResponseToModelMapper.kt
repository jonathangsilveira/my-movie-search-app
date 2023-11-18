package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.mapper.Mapper
import com.silveira.jonathang.android.domain.model.MovieResultModel
import com.silveira.jonathang.android.remote.response.MovieResultResponse

internal class MovieResponseToModelMapper : Mapper<MovieResultResponse, MovieResultModel> {
    override fun map(
        source: MovieResultResponse
    ): MovieResultModel = with(source) {
        MovieResultModel(
            id = id,
            title = title,
            posterPath = posterPath,
            popularity = popularity,
            originalLanguage = originalLanguage,
            releaseDate = releaseDate
        )
    }
}