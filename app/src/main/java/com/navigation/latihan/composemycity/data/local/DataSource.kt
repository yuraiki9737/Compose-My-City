package com.navigation.latihan.composemycity.data.local

import com.navigation.latihan.composemycity.R
import com.navigation.latihan.composemycity.data.model.Category
import com.navigation.latihan.composemycity.data.model.Recommendation

object DataSource {

    val recomendations = listOf(
        Recommendation(
            R.string.title_taman_sri_deli,
            R.string.description_taman_sri_deli,
            R.drawable.taman_sri_deli,
            Category.GARDEN
        ),
        Recommendation(
            R.string.title_taman_kebun_bunga,
            R.string.description_taman_kebun_bunga,
            R.drawable.taman_kebun_bunga,
            Category.GARDEN
        ),
        Recommendation(
            R.string.title_taman_candika_pramuka,
            R.string.description_taman_candika_pramuka,
            R.drawable.taman_cadika,
            Category.GARDEN
        ),
        Recommendation(
            R.string.title_cofeelab,
            R.string.description_cofeelab,
            R.drawable.cofeelab,
            Category.COFFEE_SHOP
        ),
        Recommendation(
            R.string.title_coffeeloca,
            R.string.description_cofeeloca,
            R.drawable.coffeeloca,
            Category.COFFEE_SHOP
        ),
        Recommendation(
            R.string.title_aduacoffee,
            R.string.description_aduacoffee,
            R.drawable.aduacoffee,
            Category.COFFEE_SHOP
        ),
        Recommendation(
            R.string.title_restoran_pohon_pisang,
            R.string.description_restoran_pohon_pisang,
            R.drawable.restoran_pohon_pisang,
            Category.RESTAURANT
        ),
        Recommendation(
            R.string.title_ayam_pepes_medan,
            R.string.description_ayam_pepes_medan,
            R.drawable.ayam_pepes_medan,
            Category.RESTAURANT
        ),
        Recommendation(
            R.string.title_wajir_seafood,
            R.string.description_wajir_seafood,
            R.drawable.wajirseafood,
            Category.RESTAURANT
        )
    )
}