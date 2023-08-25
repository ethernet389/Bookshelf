package com.ethernet389.domain.use_case

import com.ethernet389.domain.model.Book
import com.ethernet389.domain.repository.BookRepository

class BookLoader(
    private val bookRepository: BookRepository
) {
    suspend fun load(query: String): List<Book> {
        return bookRepository.loadBooks(query)
    }
}