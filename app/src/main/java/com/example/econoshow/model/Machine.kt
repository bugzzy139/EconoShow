package com.example.econoshow.model

import androidx.annotation.RawRes
import androidx.annotation.StringRes

data class Machine(
    val id: Int,
    @StringRes val name: Int,
    @RawRes val brochure: Int? = null,
    val videos: List<Video> = listOf(),
    val layouts: List<Layout> = listOf(),
)
