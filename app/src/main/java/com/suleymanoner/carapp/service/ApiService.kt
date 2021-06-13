package com.suleymanoner.carapp.service

import com.suleymanoner.carapp.model.Cars
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("Android-Team-BootCamp/carsjson/master/carsdb.json")
    fun getCars(): Single<List<Cars>>
}