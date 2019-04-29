package com.example.livedataroom.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AvengersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAvenger(avenger: Avengers)

    @Delete
    fun deleteAvenger(avenger: Avengers)

    @Query("SELECT * FROM Avengers")
    fun getAllAvengers(): LiveData<List<Avengers>>
}