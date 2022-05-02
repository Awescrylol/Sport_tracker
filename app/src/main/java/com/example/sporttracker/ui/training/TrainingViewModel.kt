package com.example.sporttracker.ui.training

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrainingViewModel : ViewModel() {

    private val _text = MutableLiveData("This is Training Fragment")
    val text: LiveData<String> = _text
}