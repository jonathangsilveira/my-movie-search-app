package com.silveira.jonathang.android.remote

import okhttp3.Interceptor
import okhttp3.Response

private const val APPLICATION_JSON = "application/json"

internal class TmdbHeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestWithHeaders = originalRequest.newBuilder()
            .addHeader("accept", APPLICATION_JSON)
            .addHeader(
                "Authorization",
                "Bearer x.y.z"
            )
            .build()
        return chain.proceed(requestWithHeaders)
    }
}