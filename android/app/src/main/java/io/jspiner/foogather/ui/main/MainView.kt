package io.jspiner.foogather.ui.main

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import io.jspiner.foogather.ui.main.home.HomeView
import io.jspiner.foogather.ui.main.reserve.ReserveView
import io.jspiner.foogather.ui.main.settings.SettingsView

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    MainView()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainView(onHomeItemClick: () -> Unit = {}) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController, onHomeItemClick)
    }
}

@Composable
private fun Navigation(navController: NavHostController, onHomeItemClick: () -> Unit = {}) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeView(onHomeItemClick)
        }
        composable(NavigationItem.Reserve.route) {
            ReserveView()
        }
        composable(NavigationItem.Settings.route) {
            SettingsView()
        }
    }
}

@Composable
private fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Reserve,
        NavigationItem.Settings
    )
    BottomNavigation(
        backgroundColor = Color.Red,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Filled.Home, "홈")
    object Reserve : NavigationItem("reserve", Icons.Filled.List, "예약")
    object Settings : NavigationItem("settings", Icons.Filled.Settings, "설정")
}
