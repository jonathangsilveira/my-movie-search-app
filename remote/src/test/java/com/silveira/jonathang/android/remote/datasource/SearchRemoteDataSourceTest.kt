package com.silveira.jonathang.android.remote.datasource

import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.remote.SearchService
import com.silveira.jonathang.android.remote.mapper.HeaderToMapMapper
import com.silveira.jonathang.android.remote.mapper.QueryToMapMapper
import com.silveira.jonathang.android.remote.mapper.SearchResponseToModelMapper
import com.silveira.jonathang.android.remote.response.SearchResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class SearchRemoteDataSourceTest {

    private val service = mockk<SearchService>()

    private val headerMapper = mockk<HeaderToMapMapper> {
        every { map(any()) } returns emptyMap()
    }

    private val queryMapper = mockk<QueryToMapMapper> {
        every { map(any()) } returns emptyMap()
    }

    private val responseToModelMapper = mockk<SearchResponseToModelMapper>()

    private val remoteDataSource = SearchRemoteDataSourceImpl(
        searchService = service,
        headerToMapMapper = headerMapper,
        queryToMapMapper = queryMapper,
        responseToModelMapper = responseToModelMapper
    )

    @Test
    fun `search Should return a success response When service is available`() {
        runTest {
            // Given
            val header = SearchHeaderModel(accept = "json", accessToken = "1234")
            val query = SearchQueryModel(query = "arnold", language = "pt-BR")
            val response = SearchResponse(
                page = 1,
                totalPages = 1,
                totalResults = 0,
                results = emptyList()
            )
            val expected = SearchResultPageModel(
                page = 1,
                totalPages = 1,
                totalResults = 0,
                results = emptyList()
            )

            coEvery { service.multiSearch(any(), any()) } returns response
            every { responseToModelMapper.map(any()) } returns expected

            // When
            val actual = remoteDataSource.search(header, query)

            // Then
            verify {
                headerMapper.map(header)
                queryMapper.map(query)
                responseToModelMapper.map(response)
            }
            coVerify {
                service.multiSearch(emptyMap(), emptyMap())
            }
            assertEquals(expected, actual)
        }
    }

    @Test(expected = Exception::class)
    fun `search Should return a failure response When header has no accessToken`() {
        runTest {
            // Given
            val header = SearchHeaderModel(accept = "json", accessToken = "")
            val query = SearchQueryModel(query = "arnold", language = "pt-BR")

            coEvery {
                service.multiSearch(any(), any())
            } throws Exception("Invalid API key: You must be granted a valid key.")

            // When
            remoteDataSource.search(header, query)

            // Then
            verify {
                headerMapper.map(header)
                queryMapper.map(query)
            }
            coVerify {
                service.multiSearch(emptyMap(), emptyMap())
            }
        }
    }
}