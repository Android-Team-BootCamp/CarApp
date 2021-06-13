package com.suleymanoner.carapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.suleymanoner.carapp.R
import com.suleymanoner.carapp.databinding.ItemcarsBinding
import com.suleymanoner.carapp.model.Cars

class CarsAdapter(val carsList: List<Cars>, val onItemClick:(Cars)->Unit): RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {



    class CarsViewHolder(var view: ItemcarsBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(model: Cars, onItemClick: (Cars) -> Unit){
            itemView.setOnClickListener { onItemClick(model) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemcarsBinding>(inflater,R.layout.itemcars,parent,false)

       // inflater.inflate(R.layout.itemcars,parent,false)
        return CarsViewHolder(view)

    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
       // holder.view. = movieDetailList[position]

//
//        holder.view.setOnClickListener {
//            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
//            Navigation.findNavController(it).navigate(action)
//        }

    }


//    fun updateCountryList(newCountryList: List<Country>) {
//        countryList.clear()
//        countryList.addAll(newCountryList)
//        notifyDataSetChanged()
//    }
}