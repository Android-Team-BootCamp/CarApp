package com.suleymanoner.carapp.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.suleymanoner.carapp.model.Cars

@Database(entities = [Cars::class], version = 1)
abstract class CarsDatabase: RoomDatabase() {

    abstract fun carsDao(): CarsDao

    companion object {
        @Volatile
        var instance: CarsDatabase? = null

        @Synchronized
        fun getInstance(context: Context): CarsDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarsDatabase::class.java,
                    "cars.db"
                ).build()
            }
            return instance as CarsDatabase
        }
    }
}