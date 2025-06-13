package econoshow.utils

import android.util.Log
import kotlinx.coroutines.delay

/**
 * Controls the AFK counter
 *
 * This is used to determine whether someone has stopped interacting with the app. After 3 minutes, the app will consider that the user
 * has walked away and call [startTimer]'s callback.
 *
 * @property currentTime The current time that has elapsed since the last interaction from the [com.example.econoshow.MainActivity]
 * @property maxTime The amount of time in seconds to wait before considered 'AFK'
 */
object AfkController {
    private var currentTime = 0
    private const val maxTime = 180

    /**
     * Resets the AFK timer
     *
     * Sets the [currentTime] variable to 0
     *
     * @see [com.example.econoshow.MainActivity]
     */
    fun resetTimer() {
        currentTime = 0
    }

    /**
     * Starts the AFK timer
     *
     * Once the max amount of time has elapsed, the callback method if invoked. This coroutine is cancelled when the app
     * returns to the home screen.
     *
     * @param finishAndWait The callback that is invoked after the max amount of time has passed.
     */
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