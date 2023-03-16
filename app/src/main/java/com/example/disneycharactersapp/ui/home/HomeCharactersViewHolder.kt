package com.example.disneycharactersapp.ui.home


import android.view.ViewGroup
import com.example.disneycharactersapp.databinding.CharacterHomeItemBinding
import com.example.disneycharactersapp.ui.base.BaseViewHolder
import com.example.disneycharactersapp.util.inflateAdapterItem

class HomeCharactersViewHolder(
    private val binding : CharacterHomeItemBinding,
    private val itemClick: ((Int)->Unit)?
): BaseViewHolder<HomeUiData>(binding.root){
    companion object{
        fun createFrom(parent:ViewGroup,itemClickListener : ((Int) -> Unit)?) =
            HomeCharactersViewHolder(parent.inflateAdapterItem(CharacterHomeItemBinding::inflate),itemClickListener)
    }
    override fun onBind(data: HomeUiData) {
        binding.characterComponent.setCharacterData(homeUiData = data)
        binding.characterComponent.setOnClickListener {
            itemClick?.invoke(data.Id!!)
        }
    }
}