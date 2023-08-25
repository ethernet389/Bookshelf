package com.ethernet389.data.repository

import com.ethernet389.data.model.toBook
import com.ethernet389.data.service.RetrofitBookService
import com.ethernet389.domain.model.Book
import com.ethernet389.domain.repository.BookRepository

class NetworkBookRepository(
    private val retrofitBookService: RetrofitBookService
) : BookRepository {

    override suspend fun loadBooks(searchQuery: String): List<Book> {
        val resultList = retrofitBookService
            .loadBooksBySearchWords(query = searchQuery.replace(' ', '+'))
        return resultList.map { it.toBook() }
    }
}