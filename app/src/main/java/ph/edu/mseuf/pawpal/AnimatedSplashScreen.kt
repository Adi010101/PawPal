package ph.edu.mseuf.pawpal

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import ph.edu.mseuf.pawpal.ui.theme.DarkBlue

//For the Animation of the Splash Screen
@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState( //default value of alpha is zero or 0f
        targetValue = if (startAnimation) 1f else 0f,
        //stores the specification of an animation
        animationSpec = tween(
            durationMillis = 3000 //seconds
        )
    )
    //LaunchedEffect will trigger the CoroutineScope
    //this is where splash screen enter
   LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000) // seconds
       //after the start animation changed into true, there will be fade in animation
       navController.popBackStack() //to close the application when pressing the back button
        navController.navigate("login_page") //navigate the login screen
    }
    Splash(alpha = alphaAnim.value)//passing the value of Alpha
}

//Design of the Splash Screen
@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else DarkBlue)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.adoption_w),
            contentDescription = "Logo Icon",
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha) //passing of alphaAnim
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}
