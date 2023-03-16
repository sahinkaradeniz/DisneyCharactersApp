package com.example.disneycharactersapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.disneycharactersapp.databinding.DetailChildRowItemBinding

class DetailChildAdapter (private val products: List<String>):
    RecyclerView.Adapter<DetailChildAdapter.ChildViewHolder>() {
    class ChildViewHolder( private val binding:DetailChildRowItemBinding):ViewHolder(binding.root){
            fun bind(name:String){
                binding.productName.text=name
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val rowRcv=DetailChildRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChildViewHolder(rowRcv)
    }

    override fun getItemCount(): Int {
       return products.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(products[position])
    }

}