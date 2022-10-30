package com.navigation.latihan.composemycity.ui

import com.navigation.latihan.composemycity.data.model.Recommendation

data class RecommendationUiState (
    val gardens: List<Recommendation> = emptyList(),
    val coffees: List<Recommendation> = emptyList(),
    val restaurants: List<Recommendation> = emptyList(),
    val recommendation: Recommendation? = null,
    val currentScreen: AppScreen = AppScreen.Garden,
    val loading: Boolean = false
)

