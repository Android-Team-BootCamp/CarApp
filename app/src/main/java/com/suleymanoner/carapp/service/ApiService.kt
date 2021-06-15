package com.suleymanoner.carapp.service

import com.suleymanoner.carapp.model.Cars
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("Android-Team-BootCamp/carsjson/master/carsdb.json")
    fun getCars(): Single<List<Cars>>


    @GET("movie/{id}")
    fun getCarsDetails(@Path("id") carsId: Int): Single<Cars>
}