package com.silveira.jonathang.android.remote

import com.silveira.jonathang.android.remote.response.MovieResultResponse
import com.silveira.jonathang.android.remote.response.PersonResultResponse
import com.silveira.jonathang.android.remote.response.SearchResultResponse
import com.silveira.jonathang.android.remote.response.TvShowResultResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

class JsonProviderImpl : JsonProvider {
    override val json: Json
        get() = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            serializersModule = SerializersModule {
                polymorphic(SearchResultResponse::class) {
                    subclass(PersonResultResponse::class)
                    subclass(TvShowResultResponse::class)
                    subclass(MovieResultResponse::class)
                }
            }
        }
}