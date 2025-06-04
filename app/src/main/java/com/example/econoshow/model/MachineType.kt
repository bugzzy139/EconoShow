package com.example.econoshow.model

import androidx.annotation.StringRes

data class MachineType(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
)
