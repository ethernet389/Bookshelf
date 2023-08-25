package com.ethernet389.bookshelf.di

import com.ethernet389.bookshelf.view_model.BookViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        BookViewModel(get())
    }
}