package com.suleymanoner.carapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.suleymanoner.carapp.model.Cars
import com.suleymanoner.carapp.service.ApiClient

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()

    val searchcars = MutableLiveData<List<Cars>>()

    fun getSearchCars(search: String) {
        disposable.add(
            apiClient.getSearchCars(search)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Cars>>() {
                    override fun onSuccess(t: List<Cars>) {
                        searchcars.value = t
                    }

                    override fun onError(e: Throwable) {

                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}