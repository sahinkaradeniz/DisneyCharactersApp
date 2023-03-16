package com.example.disneycharactersapp.ui.companent

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.disneycharactersapp.databinding.CharacterHomeComponentBinding
import com.example.disneycharactersapp.ui.home.HomeUiData
import com.example.disneycharactersapp.util.loadUrl

class HomeCharacterComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = 0,
) : FrameLayout(context,attributeSet,defStyleAttr) {
    private val _binding = CharacterHomeComponentBinding.inflate(LayoutInflater.from(context),this,false)

    init {
        addView(_binding.root)
    }
    fun setCharacterData(homeUiData: HomeUiData){
        _binding.imageView.loadUrl(
            homeUiData.imageUrl
        )
        _binding.nameText.text=homeUiData.name
    }
}
