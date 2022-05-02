package com.example.sporttracker.ui.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressViewModel : ViewModel() {

    private val _text = MutableLiveData("This is Progress Fragment")
    val text: LiveData<String> = _text
}