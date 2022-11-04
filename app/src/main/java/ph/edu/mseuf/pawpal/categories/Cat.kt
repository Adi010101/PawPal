package ph.edu.mseuf.pawpal.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ph.edu.mseuf.pawpal.*
import ph.edu.mseuf.pawpal.R
import ph.edu.mseuf.pawpal.navigation.CategoryScreen
import ph.edu.mseuf.pawpal.navigation.Screen
import ph.edu.mseuf.pawpal.navigation.items
import ph.edu.mseuf.pawpal.ui.theme.*

//Design of the HomeScreen
@Composable
fun HomeView(navController: NavController) {
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
                painter = painterResource(R.drawable.user),
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
        Image(
            painter = painterResource(R.drawable.header),
            contentDescription = "header",
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 10.dp)
        )
        Text(
            text = "Pet Categories",
            fontWeight = FontWeight.Bold,
            color = Grayish,
            textAlign = TextAlign.Start,
            fontSize = 15.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,horizontalArrangement = Arrangement.SpaceBetween){
            Button(
                onClick = {navController.navigate(CategoryScreen.Cat.route)},
                modifier = Modifier
                    .size(width = 150.dp,height = 35.dp),
                shape = CircleShape,
                colors= ButtonDefaults.buttonColors(backgroundColor = DarkBlue, contentColor = Color.White),
                elevation = ButtonDefaults.elevation(2.dp,2.dp)
            ) {
                Image (painterResource(id = R.drawable.cat), contentDescription = "Cat")
                Text(text = " Cat")
            }
            Button(
                onClick = {navController.navigate(CategoryScreen.Dog.route)},
                modifier = Modifier
                    .size(width = 150.dp,height = 35.dp),
                shape = CircleShape,
                colors= ButtonDefaults.buttonColors(backgroundColor = White, contentColor = Grayish),
                elevation = ButtonDefaults.elevation(2.dp,2.dp)
            ) {
                Image (painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    alignment = Alignment.TopStart)
                Text(text = " Dog")
            }
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
            Text(
                text = "See all",
                fontWeight = FontWeight.SemiBold,
                color = DarkBlue,
                textAlign = TextAlign.End,
                fontSize = 18.sp,
                modifier = Modifier
                        .clickable {
                    navController.navigate(CategoryScreen.SeeAllCat.route)
                }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            LazyRowItem()
        }
    }
}


@Composable
fun CatCategory() {
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
                HomeView(navController = navController)
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
        }
    }
}


//LazyRow Items
@Composable
fun LazyRowItem() {
    Column {
        LazyRow(Modifier.height(300.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                RowItem(
                    imagePainter = painterResource(id = R.drawable.catpic),
                    title = "Eli",
                    icon = painterResource(id = R.drawable.male),
                    backgroundColor = White
                ){}
            }
            item {
                RowItem(
                    imagePainter = painterResource(id = R.drawable.catpic2),
                    title = "Tigri",
                    icon = painterResource(id = R.drawable.female),
                    backgroundColor = White
                ){}
            }

        }
    }
}


//Design of the Lazy Row
@Composable
fun RowItem(
    title: String = "",
    backgroundColor: Color = White,
    icon: Painter,
    imagePainter: Painter,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(190.dp)
            .height(220.dp)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(bounded = true, color = Color.Black),
                onClick = onItemClick
            ),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = backgroundColor,
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "Image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    color = Grayish,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
                Image(
                    painter = icon, contentDescription = "male",
                    modifier = Modifier.padding(10.dp)
                        .width(25.dp)
                )
            }
        }
    }
}


//Previews
@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    SearchView(textState)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CatCategory()
    HomeView(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun LazyRowPreview()
{
    LazyRowItem()
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController(), items)
}

