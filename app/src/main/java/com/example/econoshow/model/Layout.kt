package com.example.econoshow.model

import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.example.econoshow.R

data class Layout (
    val id: Int,
    @StringRes val titleRes: Int = R.string.layout_title_default,
    @RawRes val layoutRes: Int
)