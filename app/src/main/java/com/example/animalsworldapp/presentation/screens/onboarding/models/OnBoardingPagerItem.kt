package com.example.animalsworldapp.presentation.screens.onboarding.models

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.AnimalsWorldApp.R

sealed class OnBoardingPagerItem(
    @DrawableRes open val buttonTextId: Int,
    open val isLatPage: Boolean
) {
    data class Welcome(
        @DrawableRes val imageId: Int,
        @DrawableRes override val buttonTextId: Int,
        @StringRes val titleId: Int,
        @DrawableRes val backgroundId: Int,
    ) : OnBoardingPagerItem(buttonTextId, false)

    data class OnBoarding(
        @DrawableRes val imageId: Int,
        @StringRes val titleId: Int,
        @DrawableRes override val buttonTextId: Int,
        @StringRes val descripitionId: Int,
        override val isLatPage: Boolean = false
    ) : OnBoardingPagerItem(buttonTextId, isLatPage)


    companion object {
        @SuppressLint("ResourceType")
        fun onBoardingItem() = listOf<OnBoardingPagerItem>(
            Welcome(
                imageId = R.drawable.welcome_image,
                titleId = R.string.welcome,
                backgroundId = R.string.welcome,
                buttonTextId = R.string.lets_go
            ),
            OnBoarding(
                imageId = R.drawable.first_onboarding_image,
                titleId = R.string.first_onboarding_title,
                descripitionId = R.string.first_onboarding_descripition,
                buttonTextId = R.string.whats_next

            ),
            OnBoarding(
                imageId = R.drawable.second_onboarding_image,
                titleId = R.string.second_onboarding_title,
                descripitionId = R.string.second_onboarding_descripition,
                buttonTextId = R.string.got_it

            ),
            OnBoarding(
                imageId = R.drawable.third_onboarding_image,
                titleId = R.string.third_onboarding_title,
                descripitionId = R.string.third_onboarding_descripition,
                buttonTextId = R.string.get_started,
                isLatPage = true,
            ),
        )
    }
}
