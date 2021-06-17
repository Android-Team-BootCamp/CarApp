package com.suleymanoner.carapp.service

import androidx.lifecycle.LiveData
import androidx.room.*
import com.suleymanoner.carapp.model.Cars

@Dao
interface CarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCars(cars: Cars?)

    @Delete
    fun deleteCars(cars: Cars?)

    @Query("SELECT * FROM cars")
    fun getAllCars(): LiveData<List<Cars>>

    @Query("SELECT * FROM cars WHERE id = :carsId")
    fun getSingleCars(carsId:Int): LiveData<Cars>
}