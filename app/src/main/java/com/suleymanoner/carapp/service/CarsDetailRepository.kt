package com.suleymanoner.carapp.service

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.suleymanoner.carapp.model.Cars

class CarsDetailRepository (context: Context) {

    private val db: CarsDatabase by lazy { CarsDatabase.getInstance(context) }
    private val dao: CarsDao by lazy { db.carsDao()}

    fun insertCars(movieResult: Cars?){
        InsertAsyncTask(
            dao
        ).execute(movieResult)
    }

    fun deleteCars(movieResult: Cars?){
        DeleteAsyncTask(
            dao
        ).execute(movieResult)
    }

    fun getAllCars(): LiveData<List<Cars>> {
        return dao.getAllCars()
    }

    fun getSingleCars(movieId:Int?): LiveData<Cars> {
        return dao.getSingleCars(movieId!!)
    }

    private class InsertAsyncTask(val dao: CarsDao): AsyncTask<Cars, Void, Void>(){
        override fun doInBackground(vararg params: Cars?): Void? {
            dao.insertCars(params[0])
            return null
        }
    }

    private class DeleteAsyncTask(val dao: CarsDao): AsyncTask<Cars, Void, Void>(){
        override fun doInBackground(vararg params: Cars?): Void? {
            dao.deleteCars(params[0])
            return null
        }
    }

}