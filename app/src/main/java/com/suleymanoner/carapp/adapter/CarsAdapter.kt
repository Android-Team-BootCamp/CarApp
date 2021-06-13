package com.suleymanoner.carapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.suleymanoner.carapp.R
import com.suleymanoner.carapp.databinding.ItemCarsBinding
import com.suleymanoner.carapp.model.Cars

class CarsAdapter(val carsDetailList: List<Cars>, val onItemClick:(Cars)->Unit) :
RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {

    class CarsViewHolder(var view: ItemCarsBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(model: Cars, onItemClick: (Cars) -> Unit) {
            itemView.setOnClickListener { onItemClick(model) }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            DataBindingUtil.inflate<ItemCarsBinding>(inflater, R.layout.item_cars, parent, false)
        return CarsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.view.cars = carsDetailList[position]
        holder.bind(carsDetailList[position],onItemClick)
    }

    override fun getItemCount(): Int {
        return carsDetailList.size
    }
}