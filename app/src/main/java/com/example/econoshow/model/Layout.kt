package com.example.econoshow.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.example.econoshow.R

data class Layout (
    val id: Int,
    @StringRes val titleRes: Int = R.string.layout_title_default,
    @RawRes val layoutRes: Int,
    @DrawableRes val layoutThumbnailRes: Int = R.drawable.video_thumbnail_default,
)