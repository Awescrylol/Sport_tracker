package com.example.sporttracker.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sporttracker.di.ViewModelFactory
import com.example.sporttracker.di.ViewModelKey
import com.example.sporttracker.presentation.ProfileViewModel
import com.example.sporttracker.presentation.ProgressViewModel
import com.example.sporttracker.presentation.TrainingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PresentationModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProgressViewModel::class)
    fun bindProgressViewModel(viewModel: ProgressViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrainingViewModel::class)
    fun bindTrainingViewModel(viewModel: TrainingViewModel): ViewModel
}