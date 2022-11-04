package ph.edu.mseuf.pawpal

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ph.edu.mseuf.pawpal.categories.CatCategory
import ph.edu.mseuf.pawpal.categories.DogCategory
import ph.edu.mseuf.pawpal.model.Dog
import ph.edu.mseuf.pawpal.navigation.CategoryScreen
import ph.edu.mseuf.pawpal.navigation.Screen
import ph.edu.mseuf.pawpal.navigation.items
import ph.edu.mseuf.pawpal.ui.theme.DarkBlue
import ph.edu.mseuf.pawpal.ui.theme.LightBlue
import ph.edu.mseuf.pawpal.ui.theme.White

@Composable
fun ProfileScreen(dog: Dog, onNavIconPressed: () -> Unit = { }) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    ProfileHeader(
                        scrollState,
                        dog,
                        this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(dog, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    puppy: Dog,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .height(346.dp)
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = painterResource(id = puppy.image),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(dog: Dog, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp)
            .background(color = White))

        Name(dog)
        Text(text = "My Story",fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(15.dp), textAlign = TextAlign.Start, color = DarkBlue)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = dog.about,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
            color = DarkBlue,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Dog info",fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(15.dp), textAlign = TextAlign.Start, color = DarkBlue)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoCard(title = "Age", value = dog.age.toString().plus(" yrs"))
            InfoCard(title = "Color", value = dog.color)
            InfoCard(title = "Weight", value = dog.weight.toString().plus("Kg"))
        }

        // Add a spacer that always shows part (320.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { /* Do something! */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = DarkBlue,
                contentColor = Color.White
            )
        ) {
            Text("Adopt me")
        }
        Spacer(modifier = Modifier.height(24.dp))
        //Spacer(Modifier.height((containerHeight - 0.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
fun DetailsNavigation() {
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
            composable(CategoryScreen.Details.route) {
                ProfileScreen(dog = Dog(
                    0,
                    "Eli",
                    3.5,
                    "Male",
                    "Orange",
                    12.9,
                    "Manila",
                    R.drawable.cat1,
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
                    "Playful"
                )
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
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
            composable(CategoryScreen.Cat.route) {
                CatCategory()
            }
            composable(CategoryScreen.Dog.route) {
                DogCategory()
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
            composable(CategoryScreen.EditProfile.route) {
                EditProfileScreen(navController = navController)
            }
        }
    }
}
/*@Composable
private fun Name(
    puppy: Puppy
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Name(
            puppy = puppy,
            modifier = Modifier.baselineHeight(32.dp)
        )
    }
}*/

@Composable
private fun Name(dog: Dog, modifier: Modifier = Modifier) {
    DogInfoCard(dog.name, dog.gender, dog.location)
}




