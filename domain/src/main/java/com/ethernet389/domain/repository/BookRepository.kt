package com.ethernet389.domain.repository

import com.ethernet389.domain.model.Book

interface BookRepository {

    suspend fun loadBooks(searchQuery: String): List<Book>
}