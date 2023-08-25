package com.ethernet389.bookshelf.di

import com.ethernet389.domain.use_case.BookLoader
import org.koin.dsl.module

val domainModule = module {
    factory {
        BookLoader(get())
    }
}