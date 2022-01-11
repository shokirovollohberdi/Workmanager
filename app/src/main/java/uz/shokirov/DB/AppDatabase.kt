package uz.shokirov.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.shokirov.entity.Valyuta

@Database(entities = [Valyuta::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun valyutaDao():ValyutoDao

    companion object{
        private var instance:AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context):AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "money_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}