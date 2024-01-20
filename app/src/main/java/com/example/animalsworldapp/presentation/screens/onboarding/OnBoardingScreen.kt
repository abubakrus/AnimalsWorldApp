package com.example.animalsworldapp.presentation.screens.onboarding

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.extensions.SpacerWidth
import com.example.animalsworldapp.presentation.extensions.advancedShadow
import com.example.animalsworldapp.presentation.screens.onboarding.models.OnBoardingPagerItem
import com.example.animalsworldapp.presentation.theme.Inter
import com.example.animalsworldapp.presentation.theme.NiramitMedium
import com.example.animalsworldapp.presentation.theme.NobileBold
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.launch

private val onBoardings = OnBoardingPagerItem.onBoardingItem()

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navigateToMainScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { onBoardings.size })
    val scope = rememberCoroutineScope()
    val onBoardings = OnBoardingPagerItem.onBoardingItem()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(
                pagerState, Modifier
            ) { position ->
                when (val onBoarding = onBoardings[position]) {
                    is OnBoardingPagerItem.Welcome -> WelcomeOnBoarding(
                        imageId = R.drawable.welcome_image, titleId = R.string.welcome
                    )

                    is OnBoardingPagerItem.OnBoarding -> {
                        OnBoardingPage(page = onBoarding)
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val page = onBoardings[pagerState.currentPage]
            if (page is OnBoardingPagerItem.OnBoarding) {
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    pageCount = onBoardings.size,
                    indicatorWidth = 30.dp,
                    indicatorHeight = 4.dp,
                    inactiveColor = Color.Gray,
                    activeColor = Color.White,
                    spacing = 15.dp,
                )
                SpacerWidth(size = 45.dp)
                OnBoardingAnimatedTextFiled(
                    modifier = Modifier,
                    page = onBoardings[pagerState.currentPage],
                    onNextPage = { isLastPage ->
                        if (isLastPage) navigateToMainScreen()
                        else scope.launch { pagerState.animateScrollToPage(pagerState.currentPage.inc()) }
                    }
                )
            }
        }
    }
}


@SuppressLint("ResourceType")
@Composable
fun OnBoardingAnimatedTextFiled(
    page: OnBoardingPagerItem,
    onNextPage: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var startAnimation by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .padding(horizontal = 16.dp)
        .height(52.dp)
        .width(150.dp)
        .advancedShadow(
            color = Color.DarkGray, alpha = 0.4f, shadowBlurRadius = 40.dp
        )
        .clip(RoundedCornerShape(25.dp))
        .background(Color.Gray)
        .clickable { onNextPage(page.isLatPage) }) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = page.buttonTextId),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Black,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPage(
    page: OnBoardingPagerItem.OnBoarding,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { onBoardings.size })
    val ifNotWelcomeScreen = pagerState.currentPage != 0

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = page.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (ifNotWelcomeScreen) {
                Spacer(modifier = Modifier.height(220.dp))
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 24.dp),
                text = stringResource(id = page.titleId),
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 40.sp,
                fontFamily = NobileBold
            )
            Text(
                modifier = Modifier
                    .padding(start = 24.dp)
                    .fillMaxWidth(),
                text = stringResource(id = page.descripitionId),
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 20.sp,
                fontFamily = NiramitMedium,
            )
        }
    }
}


@Composable
fun WelcomeOnBoarding(
    @DrawableRes imageId: Int,
    @StringRes titleId: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .padding(top = 65.dp)
                .align(Alignment.TopCenter),
            text = stringResource(id = titleId),
            textAlign = TextAlign.Center,
            fontFamily = NobileBold,
            fontSize = 40.sp,
            color = Color.White,

            )
    }
}

@Preview
@Composable
fun WelcomeOnBoardingPreview() {
    MaterialTheme {
        WelcomeOnBoarding(
            imageId = R.drawable.welcome_image, titleId = R.string.welcome
        )
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    MaterialTheme {
        OnBoardingScreen(navigateToMainScreen = {})
    }
}