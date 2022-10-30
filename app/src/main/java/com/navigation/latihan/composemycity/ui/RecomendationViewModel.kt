package com.navigation.latihan.composemycity.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navigation.latihan.composemycity.data.local.DataSource
import com.navigation.latihan.composemycity.data.model.Category
import com.navigation.latihan.composemycity.data.model.Recommendation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecomendationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RecommendationUiState())
    val uiState: StateFlow<RecommendationUiState> = _uiState.asStateFlow()

    var shouldNavigateToDetails = false
        private set

    fun setupShouldNavigateToDetails() {
        shouldNavigateToDetails = true
    }

    init {
        getRecommendations()
    }

    private fun getRecommendations() {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }
            delay(2000)
            _uiState.update { uiState ->
                val recommendations = DataSource.recomendations
                val garden = recommendations.filter { it.category == Category.GARDEN }
                val coffees = recommendations.filter { it.category == Category.COFFEE_SHOP }
                val restaurants = recommendations.filter { it.category == Category.RESTAURANT }
                val firstRecommendation = when (uiState.currentScreen) {
                    AppScreen.Garden -> garden.firstOrNull()
                    AppScreen.Coffee -> coffees.firstOrNull()
                    AppScreen.Restaurant -> restaurants.firstOrNull()
                    AppScreen.Details -> uiState.recommendation
                }
                uiState.copy(
                    gardens = garden,
                    coffees = coffees,
                    restaurants = restaurants,
                    recommendation = firstRecommendation,
                    loading = false
                )
            }
        }
    }

    // Call this before navigating to the recommendation info screen
    fun setRecommendationInfo(recommendation: Recommendation) {
        _uiState.update { it.copy(recommendation = recommendation) }
    }

    fun setRecommendationInfoForCurrentScreen(currentScreen: AppScreen) {
        _uiState.update {
            val name = currentScreen.name.lowercase()
            val found = it.recommendation?.category?.name?.lowercase() == name
            val firstRecommendation = when (currentScreen) {
                AppScreen.Garden -> if (found) it.recommendation else it.gardens.firstOrNull()
                AppScreen.Coffee -> if (found) it.recommendation else it.coffees.firstOrNull()
                AppScreen.Restaurant -> if (found) it.recommendation else it.restaurants.firstOrNull()
                AppScreen.Details -> it.recommendation
            }
            it.copy(recommendation = firstRecommendation)
        }
    }

    fun setCurrentScreen(title: String, updateFirstRecommendation: Boolean = false) {
        if (updateFirstRecommendation) {
            _uiState.update {
                val currentScreen = AppScreen.valueOf(title)
                val firstRecommendation = when (currentScreen) {
                    AppScreen.Garden -> it.gardens.firstOrNull()
                    AppScreen.Coffee -> it.coffees.firstOrNull()
                    AppScreen.Restaurant -> it.restaurants.firstOrNull()
                    AppScreen.Details -> it.recommendation
                }
                it.copy(
                    currentScreen = currentScreen,
                    recommendation = firstRecommendation
                )
            }
        } else {
            _uiState.update { it.copy(currentScreen = AppScreen.valueOf(title)) }
        }
    }
}