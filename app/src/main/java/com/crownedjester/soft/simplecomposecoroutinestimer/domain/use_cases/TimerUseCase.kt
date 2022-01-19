package com.crownedjester.soft.simplecomposecoroutinestimer.domain.use_cases

import com.crownedjester.soft.simplecomposecoroutinestimer.data.TimerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TimerUseCase(private val timerScope: CoroutineScope) {
    private var _timerStateStateFlow = MutableStateFlow(TimerState())
    val timerStateStateFlow: StateFlow<TimerState> = _timerStateStateFlow

    private var timerJob: Job? = null

    operator fun invoke(totalSeconds: Int) {
        timerJob = if (timerJob == null) {
            timerScope.launch {
                initTimer(totalSeconds)
                    .onCompletion { _timerStateStateFlow.emit(TimerState()) }
                    .collect { _timerStateStateFlow.emit(it) }
            }
        } else {
            timerJob?.cancel()
            null
        }
    }

    private fun initTimer(totalSeconds: Int): Flow<TimerState> =
        (totalSeconds - 1 downTo 0).asFlow()
            .onEach { delay(1000) }
            .onStart { emit(totalSeconds) }
            .conflate()
            .transform { remainingSeconds: Int -> emit(TimerState(remainingSeconds)) }
}