package com.example.disneycharactersapp.ui.detail

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycharactersapp.databinding.DetailChildItemBinding
import com.example.disneycharactersapp.domain.ProductTypes
import com.example.disneycharactersapp.domain.Products
import com.example.disneycharactersapp.ui.base.BaseViewHolder
import com.example.disneycharactersapp.util.hide
import com.example.disneycharactersapp.util.inflateAdapterItem
import com.example.disneycharactersapp.util.show
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DetailParentViewHolder @Inject constructor(
    private val binding: DetailChildItemBinding,
    @ApplicationContext  val context : Context,
) : BaseViewHolder<Products>(binding.root) {
    companion object {
        fun createFrom(parent: ViewGroup,@ApplicationContext context: Context) =
            DetailParentViewHolder(parent.inflateAdapterItem(DetailChildItemBinding::inflate),context)
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
            binding.cardChildItem.hide()
        } else {
            binding.cardChildItem.show()
            binding.categoryText.text = title
            binding.childRcv.adapter = adapter
            adapter.updateItems(data.products)
            binding.childRcv.layoutManager = LinearLayoutManager(context)
        }
    }
}