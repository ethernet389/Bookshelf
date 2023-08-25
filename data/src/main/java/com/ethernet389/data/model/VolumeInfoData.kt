package com.ethernet389.data.model

import com.ethernet389.domain.model.VolumeInfo
import kotlinx.serialization.Serializable


@Serializable
data class VolumeInfoData(
    val title: String,
    val authors: List<String>
)

fun VolumeInfoData.toVolumeInfo() = VolumeInfo(title = title, authors = authors)