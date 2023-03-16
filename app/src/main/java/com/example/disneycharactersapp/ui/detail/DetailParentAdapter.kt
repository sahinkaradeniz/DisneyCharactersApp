package com.example.disneycharactersapp.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.disneycharactersapp.databinding.DetailChildItemBinding
import com.example.disneycharactersapp.domain.ProductTypes
import com.example.disneycharactersapp.domain.Products
import com.example.disneycharactersapp.util.hide
import com.example.disneycharactersapp.util.show


class DetailParentAdapter(private val characters:List<Products>, val  context:Context):RecyclerView.Adapter<DetailParentAdapter.DetailParentViewHolder>(){
    class DetailParentViewHolder(private val binding:DetailChildItemBinding):ViewHolder(binding.root) {
            fun bind(character: Products,context: Context){
                val title = when(character.type) {
                    ProductTypes.TV_SHOW -> "TV SHOW"
                    ProductTypes.FILM ->  "FILM"
                    ProductTypes.VIDEO_GAME ->  "VIDEO GAME"
                    ProductTypes.SHORT_FILM ->  "SHORT FILM"
                    else -> ""
                }
                if (character.products.isEmpty()){
                    binding.cardChildItem.hide()
                }else{
                    binding.cardChildItem.show()
                    binding.categoryText.text = title
                    val adapter = DetailChildAdapter(
                        character.products
                    )
                    binding.childRcv.adapter = adapter
                    binding.childRcv.layoutManager=LinearLayoutManager(context)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailParentViewHolder {
            val rcvParent=DetailChildItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return  DetailParentViewHolder(rcvParent)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: DetailParentViewHolder, position: Int) {
            holder.bind(characters[position],context)
    }



}