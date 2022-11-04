package ph.edu.mseuf.pawpal.navigation

import ph.edu.mseuf.pawpal.R

//To link the items in a bottom nav bar to routes in my navigation graph
sealed class Screen(val route: String, var icon: Int) {


    object Home : Screen("home_screen", R.drawable.home)
    object Schedules : Screen("schedules_screen", R.drawable.calendar)
    object Favorites : Screen("favorites_screen", R.drawable.like)
    object Profile : Screen("profile_screen", R.drawable.profile_user)

    }

//place the items in a list that will be used in the BottomNavigationItem
val items = listOf(
    Screen.Home,
    Screen.Schedules,
    Screen.Favorites,
    Screen.Profile
)