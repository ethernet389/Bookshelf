package com.ethernet389.bookshelf.view_model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ethernet389.domain.model.Book
import com.ethernet389.domain.use_case.BookLoader
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BookUiState {
    object Error : BookUiState
    object Loading : BookUiState
    data class Success(val bookList: List<Book>) : BookUiState
}

class BookViewModel(
    private val bookLoader: BookLoader
) : ViewModel() {

    var bookUiState: BookUiState by mutableStateOf(BookUiState.Loading)
        private set

    init {
        updateBookList("kotlin")
    }

    fun updateBookList(query: String) {
        viewModelScope.launch {
            bookUiState = try {
                val bookList = bookLoader.load(query)
                Log.d("VIEWMODEL_BOOK_LIST", bookList.toString())
                BookUiState.Success(bookList)
            } catch (e: IOException) {
                BookUiState.Error
            } catch (e: HttpException) {
                BookUiState.Error
            }
        }
    }
}