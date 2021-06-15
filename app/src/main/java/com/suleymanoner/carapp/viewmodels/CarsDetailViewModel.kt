package com.suleymanoner.carapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.suleymanoner.carapp.model.Cars
import com.suleymanoner.carapp.service.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CarsDetailViewModel(application: Application) : AndroidViewModel(application) {


    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()
    val carsLiveData = MutableLiveData<Cars>()

    fun getCarsDetail(carsId:Int?){

        disposable.add(
            apiClient.getDetailData(carsId!!)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Cars>(){
                    override fun onSuccess(t: Cars) {
                        carsLiveData.value = t

                    }

                    override fun onError(e: Throwable) {
                        Log.i("Detail View Model" , "Hata : "+e.message)
                    }

                })
        )
    }
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}