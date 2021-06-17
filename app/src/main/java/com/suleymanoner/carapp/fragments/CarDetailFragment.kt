package com.suleymanoner.carapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.suleymanoner.carapp.R
import com.suleymanoner.carapp.databinding.FragmentCarDetailBinding

import com.suleymanoner.carapp.model.Cars
import com.suleymanoner.carapp.viewmodels.CarsDetailViewModel


class CarDetailFragment: BaseFragment<FragmentCarDetailBinding, CarsDetailViewModel>() {



    override fun getLayoutRes(): Int = R.layout.fragment_car_detail


    override fun getViewModel(): Class<CarsDetailViewModel> = CarsDetailViewModel::class.java
    private var cars: Cars? = null
    private var isFav: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        arguments?.let {
            cars = it?.getParcelable("cars_details")
            dataBinding.carsdetail = cars
            checkFav()
            dataBinding.imgFavorite.setOnClickListener {
                favorite()
//            }
            }

        }
            /*
        var movie = arguments?.getParcelable<MovieResult>("movie_details")
        dataBinding.detail = movie*/
            return dataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var CarsDetail = arguments?.getParcelable<Cars>("cars_details")
        viewModel.getCarsDetail(CarsDetail?.id)
        viewModel.carsLiveData.observe(viewLifecycleOwner, {
            it?.let {
                // dataBinding
            }
        })


    }

    private fun favorite() {
        if (isFav!!) {
            viewModel.deleteMovie(cars)
            Toast.makeText(context!!, "Removed", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.insertMovie(cars)
            Toast.makeText(context!!, "Added", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFav() {
        viewModel.getSingleMovie(cars?.id).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                dataBinding.imgFavorite.setImageResource(R.drawable.ic_favorite)
                isFav = true
            } else {
                dataBinding.imgFavorite.setImageResource(R.drawable.ic_favorite_border)
                isFav = false
            }
        })
    }





}