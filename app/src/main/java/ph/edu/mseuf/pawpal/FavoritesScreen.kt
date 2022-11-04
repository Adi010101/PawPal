package ph.edu.mseuf.pawpal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ph.edu.mseuf.pawpal.data.FakeDogDatabase
import ph.edu.mseuf.pawpal.ui.theme.Grayish
import ph.edu.mseuf.pawpal.ui.theme.LightBlue

@Composable
fun FavoritesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(text = "Favorites", fontWeight = FontWeight.Bold,color = Grayish, fontSize = 32.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Choose one of your favorites to be your buddy!", fontWeight = FontWeight.Thin,color = Grayish, fontSize = 15.sp)
    }
}



@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen()
}