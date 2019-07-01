package com.soft.paggingsampledemo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class CarAdapter() : PagedListAdapter<Car, CarViewHolder>(DIFF_UTIL) {

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Car>() {
            override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder = CarViewHolder(parent)

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
}

class CarViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
) {

    private val name = itemView.findViewById<TextView>(R.id.name)
    var car: Car? = null

    fun bindTo(car: Car?) {
        this.car = car
        name.text = car?.name
    }

}