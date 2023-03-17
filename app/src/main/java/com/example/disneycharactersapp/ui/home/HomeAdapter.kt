package com.example.disneycharactersapp.ui.home


import android.view.ViewGroup
import com.example.disneycharactersapp.ui.base.BaseRecyclerViewAdapter

class HomeAdapter(private val itemClickListener: ((Int) -> Unit)?):
    BaseRecyclerViewAdapter<HomeUiData, HomeAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
           return  HomeAdapterViewHolder.createFrom(parent,itemClickListener)
    }
}