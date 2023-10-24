package com.silveira.jonathang.android.remote

import com.silveira.jonathang.android.remote.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap

interface SearchService {

    @GET("search/multi")
    suspend fun multiSearch(
        @HeaderMap headersMap: Map<String, String>,
        @QueryMap queryMap: Map<String, String?>
    ) : SearchResponse
}