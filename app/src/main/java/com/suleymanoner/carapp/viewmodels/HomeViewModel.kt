package com.suleymanoner.carapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.suleymanoner.carapp.model.Cars
import com.suleymanoner.carapp.service.ApiClient
import com.suleymanoner.carapp.service.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()
    val cars = MutableLiveData<List<Cars>>()


    fun getDataFromAPI() {


        disposable.add(
          apiClient.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Cars>>(){
                    override fun onSuccess(t: List<Cars>) {
                        cars.value=t
//                        storeInSQLite(t)
//                        Toast.makeText(getApplication(),"Countries From API",Toast.LENGTH_LONG).show()
                    }

                    override fun onError(e: Throwable) {
//                        countryLoading.value = false
//                        countryError.value = true
                        e.printStackTrace()
                    }

                })
        )
    }
}