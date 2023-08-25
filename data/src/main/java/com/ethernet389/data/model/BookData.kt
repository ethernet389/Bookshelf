package com.ethernet389.data.model

import com.ethernet389.domain.model.Book
import kotlinx.serialization.Serializable

@Serializable
data class BookData(
    val id: String,
    val volumeInfo: VolumeInfoData,
    val imageLinks: ImageLinksData,
    val description: String
)

fun BookData.toBook() = Book(
    id = id,
    volumeInfo = volumeInfo.toVolumeInfo(),
    imageLinks = imageLinks.toImageLinks(),
    description = description
)