package com.example.sporttracker.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sporttracker.App
import com.example.sporttracker.R
import com.example.sporttracker.presentation.TrainingViewModel
import kotlinx.android.synthetic.main.training_fragment.*
import javax.inject.Inject

class TrainingFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var trainingViewModel: TrainingViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        App.component.injectTrainingFragment(this)
        trainingViewModel =
            ViewModelProvider(this, viewModelFactory).get(TrainingViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.training_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTrainingInfo()

        map.onCreate(savedInstanceState)
        map.getMapAsync { }
    }

    private fun initTrainingInfo() {
        speed.text = getString(R.string.speed, "0.00")
        time.text = getString(R.string.time, "00:00")
        distance.text = getString(R.string.distance, "0.00")
        calories.text = getString(R.string.calories, "0")
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
