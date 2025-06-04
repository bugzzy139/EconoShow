package com.example.econoshow.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.example.econoshow.R

data class Video(
    val id: Int,
    @StringRes val titleRes: Int = R.string.video_title_default,
    @RawRes val videoRes: Int,
    @DrawableRes val thumbnailRes: Int = R.drawable.video_thumbnail_default,
)
