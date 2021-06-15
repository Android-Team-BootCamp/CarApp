package com.suleymanoner.carapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suleymanoner.carapp.R
import com.suleymanoner.carapp.databinding.FragmentCarDetailBinding

import com.suleymanoner.carapp.model.Cars
import com.suleymanoner.carapp.viewmodels.CarsDetailViewModel


class CarDetailFragment: BaseFragment<FragmentCarDetailBinding, CarsDetailViewModel>() {

    private var cars: Cars? = null

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
            // checkFav()
//            dataBinding.imgFavorite.setOnClickListener {
//                favorite()
//            }
        }


        /*
        var movie = arguments?.getParcelable<MovieResult>("movie_details")
        dataBinding.detail = movie*/
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var CarsDetail = arguments?.getParcelable<Cars>("cars_details")
        viewModel.getCarsDetail(CarsDetail?.id)
        viewModel.carsLiveData.observe(viewLifecycleOwner,{
            it?.let{
                // dataBinding
            }
        })




    }




    override fun getLayoutRes(): Int =R.layout.fragment_car_detail


    override fun getViewModel(): Class<CarsDetailViewModel> = CarsDetailViewModel::class.java

}
