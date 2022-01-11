package uz.shokirov.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import android.widget.Toast

class MedialService :Service(){
    private val TAG = "MedialService"

    var mediaPlayer : MediaPlayer? = null

    override fun onBind(p0: Intent?): IBinder? {
        Log.d(TAG, "onBind: ")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
        Toast.makeText(this, "Service started mediPlayer", Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        return super.onUnbind(intent)
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate: ")
        super.onCreate()
    }

    


}