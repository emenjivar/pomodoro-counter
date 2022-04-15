package com.emenjivar.pomodoro.di

import com.emenjivar.pomodoro.screens.countdown.CountDownViewModel
import com.emenjivar.pomodoro.screens.settings.SettingsViewModel
import com.emenjivar.pomodoro.system.CustomNotificationManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        CountDownViewModel(
            getPomodoroUseCase = get(),
            setNighModeUseCase = get(),
            isNightModeUseCase = get()
        )
    }
    viewModel {
        SettingsViewModel(
            getPomodoroUseCase = get(),
            setPomodoroTimeUseCase = get(),
            setRestTimeUseCase = get()
        )
    }

    single {
        CustomNotificationManager(androidContext())
    }
}
