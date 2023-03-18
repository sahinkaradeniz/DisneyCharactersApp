package com.example.disneycharactersapp.ui.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycharactersapp.databinding.DetailChildItemBinding
import com.example.disneycharactersapp.domain.ProductTypes
import com.example.disneycharactersapp.domain.Products
import com.example.disneycharactersapp.ui.base.BaseViewHolder
import com.example.disneycharactersapp.util.gone
import com.example.disneycharactersapp.util.inflateAdapterItem
import com.example.disneycharactersapp.util.visible

class DetailParentViewHolder constructor(
    private val binding: DetailChildItemBinding
) : BaseViewHolder<Products>(binding.root) {
    companion object {
        fun createFrom(parent: ViewGroup) =
            DetailParentViewHolder(parent.inflateAdapterItem(DetailChildItemBinding::inflate))
    }

    private val adapter by lazy { DetailChildAdapter() }
    override fun onBind(data: Products) {
        val title = when (data.type) {
            ProductTypes.TV_SHOW -> "TV SHOW"
            ProductTypes.FILM -> "FILM"
            ProductTypes.VIDEO_GAME -> "VIDEO GAME"
            ProductTypes.SHORT_FILM -> "SHORT FILM"
            else -> ""
        }
        if (data.products.isEmpty()) {
            binding.cardChildItem.gone()
        } else {
            binding.cardChildItem.visible()
            binding.categoryText.text = title
            binding.childRcv.layoutManager = LinearLayoutManager(binding.root.context)
            binding.childRcv.adapter = adapter
            adapter.submitList(data.products)
        }
    }
}