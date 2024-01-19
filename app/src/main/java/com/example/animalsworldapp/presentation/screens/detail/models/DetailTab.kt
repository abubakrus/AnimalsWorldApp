package com.example.animalsworldapp.presentation.screens.detail.models

import androidx.annotation.StringRes
import com.example.AnimalsWorldApp.R


sealed class DetailTab(
    @StringRes
    val titleResId: Int
) {
    data class About(
        val about: String
    ) : DetailTab(R.string.about)

    data class InterestingFact(
        val interestingFact: String?
    ) : DetailTab(R.string.interestingFact)
}