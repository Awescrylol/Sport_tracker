package com.example.sporttracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sporttracker.R
import com.example.sporttracker.presentation.ProgressViewModel
import kotlinx.android.synthetic.main.progress_fragment.*

class ProgressFragment : Fragment() {

    private lateinit var progressViewModel: ProgressViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressViewModel = ViewModelProvider(this).get(ProgressViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.progress_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressViewModel.text.observe(viewLifecycleOwner) { text_progress.text = it }
    }
}