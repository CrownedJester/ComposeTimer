package com.crownedjester.soft.simplecomposecoroutinestimer.data

data class TimerState(
    val secondsRemaining: Int? = null,
    val totalSeconds: Int = 60,
    val stopMessage: String? = "-"
) {

    val currentStatus = (secondsRemaining ?: stopMessage).toString()

    val progressPercentage =
        (secondsRemaining ?: totalSeconds) / totalSeconds.toFloat()

    override fun toString(): String = "Seconds remaining $secondsRemaining"


}
