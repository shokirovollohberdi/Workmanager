package uz.shokirov.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.shokirov.entity.Valyuta

@Dao
interface ValyutoDao {
    @Query("select * from valyuta")
    fun getAllValyuta(): List<Valyuta>

    @Insert
    fun addValyuta(valyuta: Valyuta)

    @Update
    fun updateValyuta(valyuta: Valyuta)
}