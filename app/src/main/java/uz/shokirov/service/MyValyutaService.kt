package uz.shokirov.service

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.shokirov.DB.AppDatabase
import uz.shokirov.entity.Valyuta
import uz.shokirov.reyrofit.ApiClien
import uz.shokirov.reyrofit.ApiService

class MyValyutaService(var context: Context, var workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    private val TAG = "MyValyutaService"
    lateinit var appDatabase: AppDatabase
    override fun doWork(): Result {

        loadValyuta()

        return Result.success()
    }

    private fun loadValyuta() {
        ApiClien.getRetrofit().create(ApiService::class.java)
                .getUsers().enqueue(object : Callback<List<Valyuta>> {
                    override fun onResponse(call: Call<List<Valyuta>>, response: Response<List<Valyuta>>) {
                        if (response.isSuccessful) {
                            val body = response.body()

                            val d = ArrayList<Valyuta>()
                            d.addAll(appDatabase.valyutaDao().getAllValyuta())

                            body?.forEach {
                                if (d.isEmpty()) {
                                    appDatabase.valyutaDao().addValyuta(it)
                                } else {
                                    appDatabase.valyutaDao().updateValyuta(it)
                                }
                                Log.d(TAG, "onResponse: $it")
                                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Valyuta>>, t: Throwable) {

                    }
                })
    }

}