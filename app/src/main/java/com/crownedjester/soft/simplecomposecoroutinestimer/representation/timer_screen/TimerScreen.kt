package com.crownedjester.soft.simplecomposecoroutinestimer.representation.timer_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.crownedjester.soft.simplecomposecoroutinestimer.data.TimerState

@Composable
fun TimerScreen(timerState: TimerState, onClick: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = timerState.progressPercentage,
            modifier = Modifier
                .size(96.dp)
                .padding(8.dp)
        )

        Text(
            text = timerState.currentStatus,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.clickable { onClick() })

    }

}