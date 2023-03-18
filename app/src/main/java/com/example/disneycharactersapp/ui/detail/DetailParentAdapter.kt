package com.example.disneycharactersapp.ui.detail

import android.view.ViewGroup
import com.example.disneycharactersapp.domain.Products
import com.example.disneycharactersapp.ui.base.BaseRecyclerViewAdapter

class DetailParentAdapter: BaseRecyclerViewAdapter<Products, DetailParentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailParentViewHolder {
        return DetailParentViewHolder.createFrom(parent)
    }
}