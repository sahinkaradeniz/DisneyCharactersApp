package com.example.disneycharactersapp.ui.detail

import android.content.Context
import android.view.ViewGroup
import com.example.disneycharactersapp.domain.Products
import com.example.disneycharactersapp.ui.base.BaseRecyclerViewAdapter

class DetailParentAdapter constructor(
    val context:Context
):BaseRecyclerViewAdapter<Products,DetailParentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailParentViewHolder {
        return DetailParentViewHolder.createFrom(parent,context)
    }
}