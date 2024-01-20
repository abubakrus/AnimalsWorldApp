package com.example.animalsworldapp.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.theme.Blue

private const val DEFAULT_ICON_SIZE = 56

enum class BottomTab(
    @DrawableRes val icon: Int,
    val title: String,
    val route: String
) {
    Search(
        icon = R.drawable.search_icon,
        title = "Search",
        route = "search_screen"
    ),
    MAIN(
        icon = R.drawable.home_icon,
        title = "Main",
        route = "main_screen_route"
    ),
    PROFILE(
        icon = R.drawable.profile_icon,
        title = "Profile",
        route = "profile_screen"
    ),
}


@Composable
fun AppBottomNavigation(
    navController: NavHostController
) {
    val tabs = BottomTab.entries.toList()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colorScheme.surface
    ) {
        tabs.forEach { bottomTab ->
            AppBottomNavigationItem(
                modifier = Modifier.weight(1f),
                selected = currentRoute == bottomTab.route,
                onClick = {
                    navController.navigate(bottomTab.route) {
                        launchSingleTop = true
                    }
                },
                icon = painterResource(id = bottomTab.icon)
            )
        }
    }
}

@Composable
fun AppBottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: Painter,
    modifier: Modifier = Modifier,
    iconSize: Dp = DEFAULT_ICON_SIZE.dp,
) {
    val scale = if (selected) 1.5f else 1.0f
    val color = if (selected) Blue
    else MaterialTheme.colorScheme.secondary

    val animatedScale: Float by animateFloatAsState(
        targetValue = scale,
        animationSpec = TweenSpec(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ), label = ""
    )
    val animatedColor by animateColorAsState(
        targetValue = color,
        animationSpec = TweenSpec(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ), label = ""
    )
    IconButton(
        onClick = onClick,
        modifier = modifier.size(iconSize)
    ) {
        Icon(
            painter = icon,
            contentDescription = String(),
            tint = animatedColor,
            modifier = Modifier.scale(animatedScale)
        )
    }
}