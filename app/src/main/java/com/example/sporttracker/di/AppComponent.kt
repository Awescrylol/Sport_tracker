package com.example.sporttracker.di

import com.example.sporttracker.ui.ProfileFragment
import com.example.sporttracker.ui.ProgressFragment
import com.example.sporttracker.ui.TrainingFragment
import dagger.Component

@Component(
    modules = [
        PresentationModule::class,
    ]
)
interface AppComponent {

    fun injectProfileFragment(profileFragment: ProfileFragment)

    fun injectProgressFragment(progressFragment: ProgressFragment)

    fun injectTrainingFragment(trainingFragment: TrainingFragment)
}