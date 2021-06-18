package com.suleymanoner.carapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.suleymanoner.carapp.R
import com.suleymanoner.carapp.databinding.ItemCarsBinding
import com.suleymanoner.carapp.model.Cars


class SearchAdapter(
    val searchList: List<Cars>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    class SearchViewHolder(val binding: ItemCarsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCarsBinding>(
            inflater,
            R.layout.item_cars,
            parent,
            false
        )
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.binding.cars = searchList[position]
    }
}