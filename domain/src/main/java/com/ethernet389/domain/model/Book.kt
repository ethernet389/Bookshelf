package com.ethernet389.domain.model

data class Book(
    val id: String,
    val volumeInfo: VolumeInfo,
    val imageLinks: ImageLinks,
    val description: String
)