package com.example.disneycharactersapp.ui.home


import android.view.ViewGroup
import com.example.disneycharactersapp.ui.base.BaseRecyclerViewAdapter

class HomeAdapter(private val itemClickListener: ((Int) -> Unit)?):
    BaseRecyclerViewAdapter<HomeUiData, HomeCharactersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCharactersViewHolder {
           return  HomeCharactersViewHolder.createFrom(parent,itemClickListener)
    }
}