package com.ethernet389.bookshelf.di

import com.ethernet389.data.repository.NetworkBookRepository
import com.ethernet389.data.service.RetrofitBookService
import com.ethernet389.domain.repository.BookRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    single { retrofit() }
    single { retrofitBookService(get()) }
    single<BookRepository> { NetworkBookRepository(get()) }
}

fun retrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://www.googleapis.com/books/")
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()

fun retrofitBookService(retrofit: Retrofit): RetrofitBookService =
    retrofit.create(RetrofitBookService::class.java)