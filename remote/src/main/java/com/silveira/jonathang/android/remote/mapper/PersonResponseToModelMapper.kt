package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.mapper.Mapper
import com.silveira.jonathang.android.domain.model.PersonResultModel
import com.silveira.jonathang.android.remote.response.PersonResultResponse

internal class PersonResponseToModelMapper : Mapper<PersonResultResponse, PersonResultModel> {
    override fun map(
        source: PersonResultResponse
    ): PersonResultModel = with(source) {
        PersonResultModel(
            id = id,
            name = name,
            popularity = popularity,
            profilePath = profilePath,
            knownForDepartment = knownForDepartment
        )
    }
}