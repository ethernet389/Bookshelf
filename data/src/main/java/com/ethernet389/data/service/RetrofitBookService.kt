package com.ethernet389.data.service

import com.ethernet389.data.model.BookData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitBookService {
    @GET("{version}/volumes")
    suspend fun loadBooksBySearchWords(
        @Path("version") version: String = "v1",
        @Query("q") query: String
    ) : List<BookData>
}