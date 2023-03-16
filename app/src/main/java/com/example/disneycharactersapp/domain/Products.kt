package com.example.disneycharactersapp.domain

data class Products(
    val type: ProductTypes? = null,
    var category: String? = null,
    var products: List<@JvmSuppressWildcards String> = emptyList(),
)

enum class ProductTypes {
    FILM,
    SHORT_FILM,
    TV_SHOW,
    VIDEO_GAME
}