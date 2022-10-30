package com.navigation.latihan.composemycity.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation (
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
    val category: Category
)

enum class Category {
    GARDEN, COFFEE_SHOP, RESTAURANT
}
