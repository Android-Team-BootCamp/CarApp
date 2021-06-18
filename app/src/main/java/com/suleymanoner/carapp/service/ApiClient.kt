package com.suleymanoner.carapp.service

import com.suleymanoner.carapp.model.Cars
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(getOkhttpClient())
        .build()
        .create(ApiService::class.java)

    fun getData() : Single<List<Cars>> {
        return api.getCars()
    }
    private fun getOkhttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(RequestInterceptor())
        return client.build()
    }
    fun getDetailData(carsId:Int) :Single<Cars>{
        return api.getCarsDetails(carsId)
    }

    fun getSearchCars(name:String):Single<List<Cars>>{
        return api.getSearchCars(name)
    }
}