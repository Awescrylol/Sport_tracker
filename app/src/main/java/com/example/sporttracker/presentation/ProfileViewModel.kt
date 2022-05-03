package com.example.sporttracker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData("This is Profile Fragment")
    val text: LiveData<String> = _text
}