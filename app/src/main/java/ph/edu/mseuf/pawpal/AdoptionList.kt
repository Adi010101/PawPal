package ph.edu.mseuf.pawpal

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ph.edu.mseuf.pawpal.data.FakeDogDatabase
import ph.edu.mseuf.pawpal.navigation.CategoryScreen
import ph.edu.mseuf.pawpal.navigation.Screen
import ph.edu.mseuf.pawpal.navigation.items
import ph.edu.mseuf.pawpal.ui.theme.DarkBlue
import ph.edu.mseuf.pawpal.ui.theme.Grayish
import ph.edu.mseuf.pawpal.ui.theme.LightBlue
import ph.edu.mseuf.pawpal.ui.theme.White

@Composable
fun DogAdoptionListScreen(navController: NavController) {
    val navController = rememberNavController()
    Scaffold ( // implements the basic material design layout structure.
        bottomBar = {BottomNavigationBar(navController, items)},
        backgroundColor = LightBlue,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Hey Althea,",
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue,
                    textAlign = TextAlign.Start,
                    fontSize = 25.sp
                )
                Image(
                    painter = painterResource(R.drawable.picture),
                    contentDescription = "profile_picture",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, color = DarkBlue, CircleShape),
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "Adopt a new friend!",
                color = DarkBlue,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {navController.navigate(CategoryScreen.Search.route)},
                colors = ButtonDefaults.buttonColors(backgroundColor = White, contentColor = Grayish),
                modifier = Modifier.size(width = 330.dp,height = 47.dp),
                shape = CircleShape
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.width(290.dp))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(
                    text = "Adopt pet",
                    fontWeight = FontWeight.Bold,
                    color = Grayish,
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                LazyColumn(navController = rememberNavController(), FakeDogDatabase.dogList)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AdoptionListPreview() {
    DogAdoptionListScreen(navController = rememberNavController())
}


@Composable
fun CatAdoptionListScreen(navController: NavController) {
    val navController = rememberNavController()
    Scaffold ( // implements the basic material design layout structure.
        bottomBar = {BottomNavigationBar(navController, items)},
        backgroundColor = LightBlue,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Hey Althea,",
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue,
                    textAlign = TextAlign.Start,
                    fontSize = 25.sp
                )
                Image(
                    painter = painterResource(R.drawable.picture),
                    contentDescription = "profile_picture",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, color = DarkBlue, CircleShape),
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "Adopt a new friend!",
                color = DarkBlue,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {navController.navigate(CategoryScreen.Search.route)},
                colors = ButtonDefaults.buttonColors(backgroundColor = White, contentColor = Grayish),
                modifier = Modifier.size(width = 330.dp,height = 47.dp),
                shape = CircleShape
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.width(290.dp))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(
                    text = "Adopt pet",
                    fontWeight = FontWeight.Bold,
                    color = Grayish,
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                CatLazyColumn(navController = rememberNavController(), FakeDogDatabase.catList)
            }
        }
    }
}


@Composable
fun AdoptionListScreen(navController: NavController) {
    val navController = rememberNavController()
    Scaffold ( // implements the basic material design layout structure.
        bottomBar = {BottomNavigationBar(navController, items)},
        backgroundColor = LightBlue,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Hey Althea,",
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue,
                    textAlign = TextAlign.Start,
                    fontSize = 25.sp
                )
                Image(
                    painter = painterResource(R.drawable.picture),
                    contentDescription = "profile_picture",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, color = DarkBlue, CircleShape),
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "Adopt a new friend!",
                color = DarkBlue,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {navController.navigate(CategoryScreen.Search.route)},
                colors = ButtonDefaults.buttonColors(backgroundColor = White, contentColor = Grayish),
                modifier = Modifier.size(width = 330.dp,height = 47.dp),
                shape = CircleShape
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.width(290.dp))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(
                    text = "Adopt pet",
                    fontWeight = FontWeight.Bold,
                    color = Grayish,
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                LazyColumn(navController = rememberNavController(), FakeDogDatabase.dogList)
            }
        }
    }
}

@Composable
fun AdoptionNavigation() {
    val navController = rememberNavController() /// to use the NavController
    Scaffold ( // implements the basic material design layout structure.
        bottomBar = {BottomNavigationBar(navController, items)},
        backgroundColor = LightBlue,
        modifier = Modifier.fillMaxSize()
    ){
        NavHost( //to link the NavController with a navigation graph that specifies the composable destinations
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            //to add navigation structure
            composable(Screen.Home.route) {
                AdoptionListScreen(navController = navController)
            }
            composable(Screen.Schedules.route) {
                ScheduleScreen()
            }
            composable(Screen.Favorites.route) {
                FavoritesScreen()
            }
            composable(Screen.Profile.route) {
                EditProfileScreen(navController = navController)
            }
            composable(CategoryScreen.SeeAllCat.route) {
                CatAdoptionNavigation()
            }
            composable(CategoryScreen.SeeAllDog.route) {
                DogAdoptionNavigation()
            }
            composable(CategoryScreen.Search.route) {
                SearchBar()
            }
        }
    }
}


@Composable
fun DogAdoptionNavigation() {
    val navController = rememberNavController() /// to use the NavController
    Scaffold ( // implements the basic material design layout structure.
        bottomBar = {BottomNavigationBar(navController, items)},
        backgroundColor = LightBlue,
        modifier = Modifier.fillMaxSize()
    ){
        NavHost( //to link the NavController with a navigation graph that specifies the composable destinations
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            //to add navigation structure
            composable(Screen.Home.route) {
                DogAdoptionListScreen(navController = navController)
            }
            composable(Screen.Schedules.route) {
                ScheduleScreen()
            }
            composable(Screen.Favorites.route) {
                FavoritesScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController = navController)
            }
            composable(CategoryScreen.SeeAllCat.route) {
                CatAdoptionNavigation()
            }
            composable(CategoryScreen.SeeAllDog.route) {
                DogAdoptionNavigation()
            }
            composable(CategoryScreen.Search.route) {
                SearchBar()
            }
        }
    }
}

@Composable
fun CatAdoptionNavigation() {
    val navController = rememberNavController() /// to use the NavController
    Scaffold ( // implements the basic material design layout structure.
        bottomBar = {BottomNavigationBar(navController, items)},
        backgroundColor = LightBlue,
        modifier = Modifier.fillMaxSize()
    ){
        NavHost( //to link the NavController with a navigation graph that specifies the composable destinations
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            //to add navigation structure
            composable(Screen.Home.route) {
                CatAdoptionListScreen(navController = navController)
            }
            composable(Screen.Schedules.route) {
                ScheduleScreen()
            }
            composable(Screen.Favorites.route) {
                FavoritesScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController = navController)
            }
            composable(CategoryScreen.SeeAll.route) {
                AdoptionNavigation()
            }
            composable(CategoryScreen.SeeAllCat.route) {
                CatAdoptionNavigation()
            }
            composable(CategoryScreen.SeeAllDog.route) {
                DogAdoptionNavigation()
            }
            composable(CategoryScreen.Search.route) {
                SearchBar()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CatAdoptionListPreview() {
    CatAdoptionListScreen(navController = rememberNavController())
}