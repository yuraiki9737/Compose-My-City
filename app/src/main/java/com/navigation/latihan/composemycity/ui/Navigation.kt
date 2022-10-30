package com.navigation.latihan.composemycity.ui

import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.LocalFlorist
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.LocalFlorist
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.ui.graphics.vector.ImageVector
import com.navigation.latihan.composemycity.R


enum class AppScreen(@StringRes val title: Int){
    Garden(R.string.category_garden),
    Coffee(R.string.category_coffeeshop),
    Restaurant(R.string.category_restaurant),
    Details(R.string.recommendation_details)
}

object NavMenuItems{
    val menuItems = listOf(
        MenuItem(
            AppScreen.Garden.name,
            Icons.Outlined.LocalFlorist,
            Icons.Filled.LocalFlorist

        ),
        MenuItem(
            AppScreen.Coffee.name,
            Icons.Outlined.Coffee,
            Icons.Filled.Coffee
        ),
        MenuItem(
            AppScreen.Restaurant.name,
            Icons.Outlined.Restaurant,
            Icons.Filled.Restaurant
        )
    )
}

data class MenuItem(
    val label: String,
    val icon: ImageVector,
    val iconSelected: ImageVector
)

enum class NavigationType {
    BOTTOM, RAIL, DRAWER
}

enum class ContentType {
    LIST, LIST_DETAIL
}