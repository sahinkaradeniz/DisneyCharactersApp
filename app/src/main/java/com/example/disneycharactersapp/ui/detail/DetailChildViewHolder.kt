package com.example.disneycharactersapp.ui.detail

import android.view.ViewGroup
import com.example.disneycharactersapp.databinding.DetailChildRowItemBinding
import com.example.disneycharactersapp.ui.base.BaseViewHolder
import com.example.disneycharactersapp.util.inflateAdapterItem

class DetailChildViewHolder(private val binding:DetailChildRowItemBinding):BaseViewHolder<String>(binding.root) {
    companion object{
        fun createFrom(parent: ViewGroup) =
            DetailChildViewHolder(parent.inflateAdapterItem(DetailChildRowItemBinding::inflate))
    }
    override fun onBind(data: String) {
        binding.productName.text=data
    }
}