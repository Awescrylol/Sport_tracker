package com.example.sporttracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sporttracker.R
import com.example.sporttracker.presentation.TrainingViewModel
import kotlinx.android.synthetic.main.training_fragment.*

class TrainingFragment : Fragment() {

    private lateinit var trainingViewModel: TrainingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        trainingViewModel = ViewModelProvider(this).get(TrainingViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.training_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        map.onCreate(savedInstanceState)
        map.getMapAsync { }
    }

    override fun onStart() {
        super.onStart()

        map.onStart()
    }

    override fun onResume() {
        super.onResume()

        map.onResume()
    }

    override fun onStop() {
        super.onStop()

        map.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        map.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        map.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()

        map.onLowMemory()
    }
}
