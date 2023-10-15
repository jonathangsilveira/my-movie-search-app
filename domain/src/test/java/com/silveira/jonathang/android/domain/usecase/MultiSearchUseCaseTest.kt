package com.silveira.jonathang.android.domain.usecase

import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.domain.repository.SearchRepository
import com.silveira.jonathang.android.domain.usecase.MultiSearchUseCaseStubs.emptyHeaderModel
import com.silveira.jonathang.android.domain.usecase.MultiSearchUseCaseStubs.emptyQueryModel
import com.silveira.jonathang.android.domain.usecase.MultiSearchUseCaseStubs.emptySearchResultPageModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MultiSearchUseCaseTest {

    private val repository = mockk<SearchRepository>()

    private val multiSearchUseCase = MultiSearchUseCase(
        repository = repository,
        coroutineContext = TestCoroutineScheduler()
    )

    @Test
    fun `invoke Should return success result When repository result is OK`() = runTest {
        // Given
        val header = emptyHeaderModel
        val query = emptyQueryModel
        val expected = Result.success(emptySearchResultPageModel)

        coEvery { repository.search(header, query) } returns emptySearchResultPageModel

        // When
        val actual = multiSearchUseCase(header, query)

        // Then
        assertTrue(actual.isSuccess)
        assertEquals(expected.getOrNull(), actual.getOrNull())
    }

    @Test
    fun `invoke Should return failure result When repository throws an Exception`() = runTest {
        // Given
        val header = emptyHeaderModel
        val query = emptyQueryModel
        val exception = Exception()
        val expected = Result.failure<SearchResultPageModel>(exception)

        coEvery { repository.search(header, query) } throws exception

        // When
        val actual = multiSearchUseCase(header, query)

        // Then
        assertTrue(actual.isFailure)
        assertEquals(expected.exceptionOrNull(), actual.exceptionOrNull())
    }
}