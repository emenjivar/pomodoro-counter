package com.emenjivar.pomodoro.screens.countdown.fullscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.emenjivar.pomodoro.screens.countdown.CountDownScreen
import com.emenjivar.pomodoro.screens.countdown.CountDownViewModel

class FullScreenActivity : ComponentActivity() {

    private lateinit var viewModel: CountDownViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CountDownViewModel::class.java)

        setContent {
            com.emenjivar.pomodoro.ui.theme.PomodoroSchedulerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CountDownScreen(
                        viewModel = viewModel,
                        modifier = Modifier.fillMaxSize(),
                        playAction = { viewModel.pauseTimer() },
                        pauseAction = { viewModel.startTimer() },
                        stopAction = { viewModel.stopTimer() },
                        fullScreenAction = { finish() },
                        isFullScreen = true
                    )
                }
            }
        }
    }
}