package com.example.sporttracker.di

import com.example.sporttracker.TrainingForegroundService
import com.example.sporttracker.di.module.ContextModule
import com.example.sporttracker.di.module.DataModule
import com.example.sporttracker.di.module.PresentationModule
import com.example.sporttracker.ui.ProfileFragment
import com.example.sporttracker.ui.ProgressFragment
import com.example.sporttracker.ui.TrainingFragment
import dagger.Component

@Component(
    modules = [
        ContextModule::class,
        DataModule::class,
        PresentationModule::class,
    ]
)
interface AppComponent {

    fun injectTrainingForegroundService(trainingForegroundService: TrainingForegroundService)

    fun injectProfileFragment(profileFragment: ProfileFragment)

    fun injectProgressFragment(progressFragment: ProgressFragment)

    fun injectTrainingFragment(trainingFragment: TrainingFragment)
}