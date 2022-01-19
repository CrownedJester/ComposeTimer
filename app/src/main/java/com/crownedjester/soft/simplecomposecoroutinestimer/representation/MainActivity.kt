package com.crownedjester.soft.simplecomposecoroutinestimer.representation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.crownedjester.soft.simplecomposecoroutinestimer.representation.timer_screen.TimerScreen
import com.crownedjester.soft.simplecomposecoroutinestimer.representation.ui.theme.SimpleComposeCoroutinesTimerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposeCoroutinesTimerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val vm = viewModel<TimerViewModel>()
                    val timer = vm.timerStateStateFlow.collectAsState()
                    TimerScreen(timerState = timer.value) { (vm::toggleTime)(60) }

                }
            }
        }
    }
}
