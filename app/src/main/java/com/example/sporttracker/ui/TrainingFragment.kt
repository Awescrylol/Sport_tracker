package com.example.sporttracker.ui

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sporttracker.App
import com.example.sporttracker.R
import com.example.sporttracker.presentation.TrainingViewModel
import kotlinx.android.synthetic.main.training_fragment.*
import javax.inject.Inject

class TrainingFragment : Fragment() {

    private companion object {

        val LOCATION_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        )
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var trainingViewModel: TrainingViewModel

    private lateinit var activityResultLauncher: ActivityResultLauncher<Array<String>>

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

        map.onCreate(savedInstanceState)
        map.getMapAsync { }
        initActivityResultLauncher()
        initTrainingInfo()
        initListeners()
    }

    private fun initActivityResultLauncher() {
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions(),
            ::handlePermissionsResult
        )
    }

    private fun handlePermissionsResult(permissions: Map<String, Boolean>) {
        if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        ) {
            Log.e("LOCATION_PERMISSIONS", "Permissions granted!")
        } else {
            Log.e("LOCATION_PERMISSIONS", "Permissions not granted!")
        }
    }

    private fun initTrainingInfo() {
        speed.text = getString(R.string.speed, "0.00")
        time.text = getString(R.string.time, "00:00")
        distance.text = getString(R.string.distance, "0.00")
        calories.text = getString(R.string.calories, "0")
    }

    private fun initListeners() {
        start.setOnClickListener {
            checkLocationPermissions()
        }
    }

    private fun checkLocationPermissions() {
        val locationPermissionsGranted = LOCATION_PERMISSIONS
            .map { permission ->
                PermissionChecker.checkSelfPermission(
                    requireActivity(),
                    permission
                )
            }
            .all { it == PackageManager.PERMISSION_GRANTED }

        val shouldShowRequestPermissionsRationale =
            LOCATION_PERMISSIONS.all(::shouldShowRequestPermissionRationale)

        when {
            locationPermissionsGranted -> Log.e("LOCATION_PERMISSIONS", "Permissions granted!")
            shouldShowRequestPermissionsRationale -> showExplainDialog()
            else -> requestLocationPermissions()
        }
    }

    private fun showExplainDialog() {
        val dialog = AlertDialog.Builder(requireContext())
            .setMessage(R.string.location_explain_dialog_message)
            .setTitle(R.string.location_explain_dialog_title)
            .setPositiveButton(R.string.confirm) { dialog, _ ->
                requestLocationPermissions()
                dialog.dismiss()
            }
            .setOnDismissListener {
                requestLocationPermissions()
            }
            .create()

        dialog.show()
    }

    private fun requestLocationPermissions() {
        activityResultLauncher.launch(LOCATION_PERMISSIONS)
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
