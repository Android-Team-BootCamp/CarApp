package com.suleymanoner.carapp.service

import com.suleymanoner.carapp.model.Cars
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("Android-Team-BootCamp/carsjson/master/carsdb.json")
    fun getCars(): Single<List<Cars>>


    @GET("cars/{id}")
    fun getCarsDetails(@Path("id") carsId: Int): Single<Cars>
    @GET("Android-Team-BootCamp/carsjson/master/carsdb.json")
    fun getSearchCars(@Query("query") name: String): Single<List<Cars>>
}