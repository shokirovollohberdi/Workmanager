package uz.shokirov.service

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import uz.shokirov.Utils.MySharedPreferences
import uz.shokirov.models.MyTime
import java.text.SimpleDateFormat
import java.util.*


class MyWorker(val context: Context, val workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    private val TAG = "MyWorker"
    override fun doWork(): Result {

        loadTime()

        return Result.success()
    }

    @SuppressLint("SimpleDateFormat")
    private fun loadTime() {
        val time = SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Date())
        Log.d(TAG, "uploadTime: $time")
        /*    var times = Times()
            times.DateTime = time
            val appDatabase = AppDatabase.getInstance(context)
            appDatabase.timeDao().addTime(times)*/
        MySharedPreferences.init(context)
        val list = MySharedPreferences.obektString
        list.add(MyTime(time))
        MySharedPreferences.obektString = list
    }

}