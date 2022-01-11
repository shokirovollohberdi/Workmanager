package uz.shokirov.workmanager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.TimeUtils
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import uz.shokirov.Utils.MySharedPreferences
import uz.shokirov.adapter.RvAdapter
import uz.shokirov.service.MyWorker
import uz.shokirov.workmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding

@SuppressLint("ServiceCast")
class MainActivity : AppCompatActivity() {
    lateinit var adapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val workRequest: WorkRequest =
            PeriodicWorkRequestBuilder<MyWorker>(15, TimeUnit.MINUTES)
                .build()
        binding.btnStart.setOnClickListener {
            WorkManager.getInstance(this)
                .enqueue(workRequest)
        }
        /*val appDatabase = AppDatabase.getInstance(this)
        val list = ArrayList<Times>()
        list.addAll(appDatabase.timeDao().getAllTime())*/
//        MySharedPreferences.init(this)
     /*   val list = MySharedPreferences.obektString
        adapter = RvAdapter(list)
        binding.rv.adapter = adapter*/
    }
}