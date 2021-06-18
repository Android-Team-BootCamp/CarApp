package com.suleymanoner.carapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.suleymanoner.carapp.R
import com.suleymanoner.carapp.adapter.SearchAdapter
import com.suleymanoner.carapp.databinding.FragmentSearchBinding
import com.suleymanoner.carapp.util.gone
import com.suleymanoner.carapp.util.visible
import com.suleymanoner.carapp.viewmodels.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_search

    override fun getViewModel(): Class<SearchViewModel> = SearchViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        dataBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null && query.length > 0){
                    viewModel.getSearchCars(query!!)
                    dataBinding.imgSearch.gone()
                    dataBinding.tvSearch.gone()
                    dataBinding.recyclerviewSearch.visible()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        dataBinding.searchView.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                dataBinding.recyclerviewSearch.gone()
                dataBinding.imgSearch.visible()
                dataBinding.tvSearch.visible()
                return false
            }
        })

        viewModel.searchcars.observe(viewLifecycleOwner, Observer {searchMovie ->
            searchMovie?.let {
                recyclerviewSearch.layoutManager = LinearLayoutManager(context!!)
                recyclerviewSearch.adapter = SearchAdapter(it){
                    val bundle = bundleOf("cars_details" to it)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_searchFragment_to_carDetailFragment,bundle)
                }

            }

        })
    }


}