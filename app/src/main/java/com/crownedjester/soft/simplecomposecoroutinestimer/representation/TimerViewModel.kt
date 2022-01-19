package com.crownedjester.soft.simplecomposecoroutinestimer.representation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crownedjester.soft.simplecomposecoroutinestimer.data.TimerState
import com.crownedjester.soft.simplecomposecoroutinestimer.domain.use_cases.TimerUseCase
import kotlinx.coroutines.flow.StateFlow

class TimerViewModel : ViewModel() {

    private val timerUseCase = TimerUseCase(viewModelScope)
    val timerStateStateFlow: StateFlow<TimerState> = timerUseCase.timerStateStateFlow

    fun toggleTime(totalSeconds: Int) = timerUseCase(totalSeconds)
}