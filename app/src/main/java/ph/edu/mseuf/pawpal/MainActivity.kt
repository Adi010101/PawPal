package ph.edu.mseuf.pawpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import ph.edu.mseuf.pawpal.categories.CatCategory
import ph.edu.mseuf.pawpal.categories.DogCategory
import ph.edu.mseuf.pawpal.navigation.CategoryScreen
import ph.edu.mseuf.pawpal.ui.theme.PawPalTheme

class MainActivity : ComponentActivity() {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawPalTheme {
                Navigation(navController = rememberNavController())
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen", content = { AnimatedSplashScreen(navController = navController)} )
        composable("home_screen", content = { BottomNavigation() })
        composable("login_page", content = { SignInForm(navController = navController, auth = Firebase) })
        composable("register_page", content = { SignUpForm(navController = navController) })
        composable("cat_category", content = { CatCategory()})
        composable("dog_category", content = { DogCategory()})
        composable("adoptionlist", content = { AdoptionNavigation()})
        composable("catlist_page", content = {CatAdoptionNavigation()})
        composable("doglist_page", content = { DogAdoptionNavigation()})
        composable("search_page", content = { BottomNavigation()})
        composable("details", content = {DetailsNavigation()})
        composable("editProfile", content = {EditProfileScreen(navController = navController)})
    }
}



