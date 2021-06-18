package com.suleymanoner.carapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.suleymanoner.carapp.R
import com.suleymanoner.carapp.adapter.CarsAdapter
import com.suleymanoner.carapp.viewmodels.BaseVMFragment
import com.suleymanoner.carapp.viewmodels.CarsDetailViewModel
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : BaseVMFragment<CarsDetailViewModel>() {

    override fun getViewModel(): Class<CarsDetailViewModel> = CarsDetailViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getAllCars().observe(viewLifecycleOwner, Observer {
            it?.let {
                recyclerviewFavorites.layoutManager = GridLayoutManager(context!!, 1)
                recyclerviewFavorites.adapter = CarsAdapter(it) {
                    val bundle = bundleOf("cars_details" to it)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_favoriteFragment_to_carDetailFragment, bundle)
                }
            }

        })
    }
}