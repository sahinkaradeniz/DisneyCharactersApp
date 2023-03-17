package com.example.disneycharactersapp.ui.detail

import android.view.ViewGroup
import com.example.disneycharactersapp.ui.base.BaseRecyclerViewAdapter

class DetailChildAdapter:BaseRecyclerViewAdapter<String,DetailChildViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailChildViewHolder {
      return  DetailChildViewHolder.createFrom(parent)
    }
}