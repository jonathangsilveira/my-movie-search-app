package com.silveira.jonathang.android.mymoviesearch.di

import com.silveira.jonathang.android.mymoviesearch.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appKoinModule = module {
    viewModel {
        SearchViewModel(
            multiSearchUseCase = get(),
            groupSearchResultBySectionUseCase = get()
        )
    }
}