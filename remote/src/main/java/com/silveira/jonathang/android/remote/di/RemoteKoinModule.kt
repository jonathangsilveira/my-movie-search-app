package com.silveira.jonathang.android.remote.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.silveira.jonathang.android.domain.datasource.SearchRemoteDataSource
import com.silveira.jonathang.android.domain.repository.SearchRepository
import com.silveira.jonathang.android.remote.JsonProviderImpl
import com.silveira.jonathang.android.remote.TmdbHeaderInterceptor
import com.silveira.jonathang.android.remote.datasource.SearchRemoteDataSourceImpl
import com.silveira.jonathang.android.remote.mapper.MovieResponseToModelMapper
import com.silveira.jonathang.android.remote.mapper.PersonResponseToModelMapper
import com.silveira.jonathang.android.remote.mapper.QueryToMapMapper
import com.silveira.jonathang.android.remote.mapper.ResultItemKey
import com.silveira.jonathang.android.remote.mapper.ResultItemValue
import com.silveira.jonathang.android.remote.mapper.SearchResponseToModelMapper
import com.silveira.jonathang.android.remote.mapper.TvShowResponseToModelMapper
import com.silveira.jonathang.android.remote.repository.SearchRepositoryImpl
import com.silveira.jonathang.android.remote.response.MovieResultResponse
import com.silveira.jonathang.android.remote.response.PersonResultResponse
import com.silveira.jonathang.android.remote.response.TvShowResultResponse
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalSerializationApi::class)
val remoteKoinModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .readTimeout(15L, TimeUnit.SECONDS)
            .connectTimeout(15L, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .addInterceptor(TmdbHeaderInterceptor())
            .build()
    }

    factory {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(get())
            .addConverterFactory(
                JsonProviderImpl()
                    .json
                    .asConverterFactory("application/json".toMediaType())
            )
            .build()
    }

    factory<SearchRemoteDataSource> {
        @Suppress("UNCHECKED_CAST")
        SearchRemoteDataSourceImpl(
            searchService = get<Retrofit>().create(),
            queryToMapMapper = QueryToMapMapper(),
            responseToModelMapper = SearchResponseToModelMapper(
                resultItemToModelMapperMap = mapOf(
                    PersonResultResponse::class to PersonResponseToModelMapper(),
                    TvShowResultResponse::class to TvShowResponseToModelMapper(),
                    MovieResultResponse::class to MovieResponseToModelMapper()
                ) as? Map<ResultItemKey, ResultItemValue>
            )
        )
    }

    factoryOf(::SearchRepositoryImpl) bind SearchRepository::class
}