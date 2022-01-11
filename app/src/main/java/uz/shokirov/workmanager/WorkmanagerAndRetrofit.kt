package uz.shokirov.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.shokirov.DB.AppDatabase
import uz.shokirov.adapter.RvValyutaAdapter
import uz.shokirov.entity.Valyuta
import uz.shokirov.reyrofit.ApiClien
import uz.shokirov.reyrofit.ApiService
import uz.shokirov.service.MyValyutaService
import uz.shokirov.service.MyWorker
import uz.shokirov.workmanager.databinding.ActivityWorkmanagerAndRetrofitBinding
import java.util.concurrent.TimeUnit


class WorkmanagerAndRetrofit : AppCompatActivity() {
    private val TAG = "WorkmanagerAndRetrofit"
    lateinit var appDatabase: AppDatabase
    lateinit var adapter: RvValyutaAdapter
    lateinit var binding: ActivityWorkmanagerAndRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkmanagerAndRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val workRequest: WorkRequest =
                    PeriodicWorkRequestBuilder<MyValyutaService>(15, TimeUnit.MINUTES)
                            .build()
            WorkManager.getInstance(this)
                    .enqueue(workRequest)
            onResume()
        }



    }

    override fun onResume() {
        super.onResume()
        appDatabase = AppDatabase.getInstance(this)
        val list = appDatabase.valyutaDao().getAllValyuta()
        Log.d(TAG, "onCreate: $list")
        adapter = RvValyutaAdapter(list)
        binding.rv.adapter = adapter
    }
}