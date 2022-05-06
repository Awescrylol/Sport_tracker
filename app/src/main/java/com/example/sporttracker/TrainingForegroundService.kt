package com.example.sporttracker

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import com.example.sporttracker.domain.usecase.GetLocationsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrainingForegroundService : LifecycleService() {

    @Inject
    lateinit var getLocationsUseCase: GetLocationsUseCase

    private companion object {

        const val NOTIFICATION_CHANNEL_ID = "TRAINING"
    }

    override fun onCreate() {
        super.onCreate()

        App.component.injectTrainingForegroundService(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        lifecycleScope.launch {
            getLocationsUseCase().collect { location ->
                Log.e("LocForegroundService", location.toString())
            }
        }

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        createNotificationChannel()

        val notification = createNotification(pendingIntent)
        startForeground(1, notification)

        return START_NOT_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val notificationChannel =
                NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "Training notification",
                    NotificationManager.IMPORTANCE_HIGH,
                )
            notificationChannel.description =
                getString(R.string.training_notification_channel_description)
            notificationChannel.enableLights(false)
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    private fun createNotification(pendingIntent: PendingIntent): Notification =
        NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setContentTitle(getString(R.string.app_name))
            .setContentText(getString(R.string.training_notification_active_content_text))
            .setSmallIcon(R.drawable.ic_training_foreground)
            .setContentIntent(pendingIntent)
            .build()
}