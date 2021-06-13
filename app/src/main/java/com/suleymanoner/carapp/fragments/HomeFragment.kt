package com.suleymanoner.carapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.suleymanoner.carapp.R
import com.suleymanoner.carapp.adapter.CarsAdapter
import com.suleymanoner.carapp.databinding.FragmentHomeBinding
import com.suleymanoner.carapp.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home
    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getDataFromAPI()
        viewModel.cars.observe(viewLifecycleOwner, Observer {
            it?.let {
                carsList.visibility=View.VISIBLE
                carsList.layoutManager=LinearLayoutManager(context!!)
                carsList.adapter=CarsAdapter(it){
                    val bundle = bundleOf("cars_details" to it)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_favoriteFragment_to_carDetailFragment,bundle)
                }
            }
        })



        super.onViewCreated(view, savedInstanceState)
    }


}