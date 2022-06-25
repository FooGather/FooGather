package io.jspiner.foogather.ui.main

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import io.jspiner.foogather.R
import io.jspiner.foogather.ui.main.home.HomeView
import io.jspiner.foogather.ui.main.reserve.ReserveView
import io.jspiner.foogather.ui.theme.Primary

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    MainView()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainView(
    onHomeItemClick: () -> Unit = {},
    onTimeSelectorClick: () -> Unit = {}
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController, onHomeItemClick, onTimeSelectorClick)
    }
}

@Composable
private fun Navigation(
    navController: NavHostController,
    onHomeItemClick: () -> Unit = {},
    onTimeSelectorClick: () -> Unit = {}
) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeView(onHomeItemClick, onTimeSelectorClick)
        }
        composable(NavigationItem.Reserve.route) {
            ReserveView()
        }
    }
}

@Composable
private fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Reserve,
    )
    BottomNavigation(
        modifier = Modifier.height(67.dp),
        backgroundColor = Color.White,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(item.icon),
                        modifier = Modifier.size(26.dp),
                        contentDescription = item.title
                    )
                },
                selectedContentColor = Primary,
                unselectedContentColor = Color.Black,
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

sealed class NavigationItem(
    var route: String,
    var icon: Int,
    var iconSelected: Int,
    var title: String
) {
    object Home :
        NavigationItem("home", R.drawable.ic_tab_home, R.drawable.ic_tab_home_selected, "홈")

    object Reserve :
        NavigationItem("reserve", R.drawable.ic_tab_list, R.drawable.ic_tab_list_selected, "예약")
}
