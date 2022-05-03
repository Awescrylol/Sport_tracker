package com.example.sporttracker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ProgressViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData("This is Progress Fragment")
    val text: LiveData<String> = _text
}