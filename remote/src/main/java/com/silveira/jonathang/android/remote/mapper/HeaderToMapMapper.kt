package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.mapper.Mapper

internal const val ACCEPT = "accept"

internal const val AUTHORIZATION = "authorization"

internal class HeaderToMapMapper : Mapper<SearchHeaderModel, Map<String, String>> {
    override fun map(source: SearchHeaderModel): Map<String, String> {
        return with(source) {
            mapOf(
                ACCEPT to accept,
                AUTHORIZATION to accessToken
            )
        }
    }
}