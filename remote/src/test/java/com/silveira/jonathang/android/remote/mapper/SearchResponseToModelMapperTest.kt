package com.silveira.jonathang.android.remote.mapper

import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.remote.response.MovieResultResponse
import com.silveira.jonathang.android.remote.response.PersonResultResponse
import com.silveira.jonathang.android.remote.response.SearchResponse
import com.silveira.jonathang.android.remote.response.TvShowResultResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class SearchResponseToModelMapperTest {

    private val personMapper = mockk<PersonResponseToModelMapper> {
        every { map(any()) } returns mockk()
    }

    private val tvShowMapper = mockk<TvShowResponseToModelMapper> {
        every { map(any()) } returns mockk()
    }

    private val movieMapper = mockk<MovieResponseToModelMapper> {
        every { map(any()) } returns mockk()
    }

    @Suppress("UNCHECKED_CAST")
    private val responseToModelMapper = SearchResponseToModelMapper(
        resultItemToModelMapperMap = mapOf(
            PersonResultResponse::class to personMapper,
            TvShowResultResponse::class to tvShowMapper,
            MovieResultResponse::class to movieMapper,
        ) as? Map<ResultItemKey, ResultItemValue>
    )

    @Test
    fun `map Should call each result mapper When results is not empty`() {
        // Given
        val response = SearchResponse(
            page = 0,
            totalPages = 0,
            totalResults = 0,
            results = listOf(
                mockk<PersonResultResponse>(),
                mockk<TvShowResultResponse>(),
                mockk<MovieResultResponse>(),
            )
        )

        // When
        responseToModelMapper.map(response)

        // Then
        verify {
            personMapper.map(any())
            tvShowMapper.map(any())
            movieMapper.map(any())
        }
    }

    @Test
    fun `map Should map response to model When is a valid response`() {
        // Given
        val response = SearchResponse(
            page = 0,
            totalPages = 0,
            totalResults = 0,
            results = emptyList()
        )
        val expected = SearchResultPageModel(
            page = 0,
            totalPages = 0,
            totalResults = 0,
            results = emptyList()
        )

        // When
        val actual = responseToModelMapper.map(response)

        // Then
        assertEquals(expected, actual)
    }
}