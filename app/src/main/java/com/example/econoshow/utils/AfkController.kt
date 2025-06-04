package com.example.econoshow.utils

import android.util.Log
import kotlinx.coroutines.delay

object AfkController {
    private var currentTime = 0
    private const val maxTime = 180

    fun resetTimer() {
        currentTime = 0
    }

    suspend fun startTimer(
        finishAndWait: () -> Unit = {}
    ) {
        while (currentTime <= maxTime) {
            Log.d("TIMER", "Current Time: $currentTime / $maxTime")
                delay(1000)
                currentTime++
                continue
        }
        finishAndWait()
    }
}