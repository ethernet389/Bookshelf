package com.ethernet389.data.model

import com.ethernet389.domain.model.ImageLinks
import kotlinx.serialization.Serializable

@Serializable
data class ImageLinksData(
    val thumbnail: String
)

fun ImageLinksData.toImageLinks() = ImageLinks(thumbnail = thumbnail)