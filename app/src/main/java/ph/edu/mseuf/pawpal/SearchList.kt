package ph.edu.mseuf.pawpal


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ph.edu.mseuf.pawpal.categories.CatCategory
import ph.edu.mseuf.pawpal.categories.DogCategory
import ph.edu.mseuf.pawpal.data.FakeDogDatabase.dogList
import ph.edu.mseuf.pawpal.model.Cat
import ph.edu.mseuf.pawpal.model.Dog
import ph.edu.mseuf.pawpal.navigation.CategoryScreen
import ph.edu.mseuf.pawpal.navigation.Screen
import ph.edu.mseuf.pawpal.navigation.Screens
import ph.edu.mseuf.pawpal.navigation.items
import ph.edu.mseuf.pawpal.ui.theme.*



@Composable
fun SearchView(state: MutableState<TextFieldValue>) { //to change the state of the text value and update the UI
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value }, //to update when the users edits the text
        modifier = Modifier
            .size(width = 330.dp,height = 47.dp),
        textStyle = TextStyle(color = DarkBlue, fontSize = 12.sp),
        label = { Text(text = "Search", color = Grayish) },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .padding(1.dp)
                    .size(25.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Search",
                        modifier = Modifier
                            .padding(1.dp)
                            .size(25.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(50.dp), // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = DarkBlue,
            cursorColor = Color.White,
            leadingIconColor = Grayish,
            trailingIconColor = DarkBlue,
            backgroundColor = White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
             disabledIndicatorColor = Color.Transparent
        )
    )
}

//Design of the HomeScreen
@Composable
fun SearchBarView(navController: NavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }

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
        SearchView(textState)
       //ItemList(navController = rememberNavController(), dogList = dogList , state = textState )
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,horizontalArrangement = Arrangement.SpaceBetween){

        }
        Spacer(modifier = Modifier.height(15.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,horizontalArrangement = Arrangement.SpaceBetween)
        {

        }
        //Spacer(modifier = Modifier.height(15.dp))
        Row {
            LazyColumn(navController = rememberNavController(), dogList)
        }
    }
}

@Composable
fun LazyColumn(navController: NavHostController, dogList: List<Dog>){
    LazyColumn {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(dogList) {
            dogList.forEach {
                ItemDogCard(
                    it,
                    onItemClicked = {dog ->
                        navController.navigate("details/${dog.id}")
                    }
                )
            }
        }
    }
}

@Composable
fun CatLazyColumn(navController: NavHostController, catList: List<Cat>){
    LazyColumn {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(catList) {
            catList.forEach {
                ItemCatCard(
                    it,
                    onItemClicked = {
                        navController.navigate(Screens.Details.route)
                    }
                )
            }
        }
    }
}

@Composable
fun ItemCatCard(cat: Cat, onItemClicked: (cat: Cat) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onItemClicked(cat) }),
        elevation = 0.dp,
        backgroundColor = White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            val image: Painter = painterResource(id = cat.image)
            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = cat.name,
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = DarkBlue,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = buildString {
                        append(cat.age)
                        append("yrs | ")
                        append(cat.attitude)
                    },
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = DarkBlue,
                    style = MaterialTheme.typography.caption
                )

                Row(verticalAlignment = Alignment.Bottom) {

                    val location: Painter = painterResource(id = R.drawable.ic_location)

                    Icon(
                        painter = location,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp, 16.dp),
                        tint = Color.Red
                    )

                    Text(
                        text = cat.location,
                        modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
                        color = DarkBlue,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                GenderTag(cat.gender)
            }
        }
    }
}

//Designs of the Card
@Composable
fun ItemDogCard(dog: Dog, onItemClicked: (dog: Dog) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onItemClicked(dog) }),
        elevation = 0.dp,
        backgroundColor = White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            val image: Painter = painterResource(id = dog.image)
            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = dog.name,
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = DarkBlue,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = buildString {
                        append(dog.age)
                        append("yrs | ")
                        append(dog.attitude)
                    },
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = DarkBlue,
                    style = MaterialTheme.typography.caption
                )

                Row(verticalAlignment = Alignment.Bottom) {

                    val location: Painter = painterResource(id = R.drawable.ic_location)

                    Icon(
                        painter = location,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp, 16.dp),
                        tint = Color.Red
                    )

                    Text(
                        text = dog.location,
                        modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
                        color = DarkBlue,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                GenderTag(dog.gender)
            }
        }
    }
}

@Composable
fun GenderTag(name: String) {
    val color = if (name == "Male") R.color.blue else R.color.red
    ChipView(gender = name, colorResource = colorResource(id = color))
}

@Composable
fun ChipView(gender: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
    ) {
        Text(
            text = gender, modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            style = MaterialTheme.typography.caption,
            color = colorResource
        )
    }
}


@Composable
fun SearchBar() {
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
                SearchBarView(navController = navController)
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
            composable(CategoryScreen.Search.route) {
                SearchBar()
            }
        }
    }
}


/*@Composable
fun SearchMain(navController: NavController) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route,) {
            SearchBarView(navController = navController)
        }
        composable(
            "${Screens.Details.route}/{id}/{title}/{location}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })) {
            Details(navController, it.arguments?.getInt("id") ?: 0)
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar()
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    SearchView(textState)
}