package ph.edu.mseuf.pawpal


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import ph.edu.mseuf.pawpal.navigation.CategoryScreen
import ph.edu.mseuf.pawpal.ui.theme.*



@Composable
fun ProfileScreen(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible: Boolean by remember {
        mutableStateOf(false)
    }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            CreateImageProfile()
            Text(
                text = "Change Profile",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = DarkBlue,
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.padding(2.dp),
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Name") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = White,
                    focusedBorderColor = DarkBlue,
                    unfocusedBorderColor = Color.DarkGray,
                    focusedLabelColor = DarkBlue,
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.DarkGray,
                ),
                singleLine = true,
                trailingIcon = {
                    if (name.isNotBlank())
                        IconButton(onClick = { name = "" }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = ""
                            )
                        }
                }
            )
            OutlinedTextField(
                modifier = Modifier.padding(2.dp),
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = White,
                    focusedBorderColor = DarkBlue,
                    unfocusedBorderColor = Color.DarkGray,
                    focusedLabelColor = DarkBlue,
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.DarkGray,
                ),
                singleLine = true,
                trailingIcon = {
                    if (email.isNotBlank())
                        IconButton(onClick = { email = "" }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = ""
                            )
                        }
                }
            )
            OutlinedTextField(
                modifier = Modifier.padding(2.dp),
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = White,
                    focusedBorderColor = DarkBlue,
                    unfocusedBorderColor = Color.DarkGray,
                    focusedLabelColor = DarkBlue,
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.DarkGray,
                ),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = "Password Toggle"
                        )
                    }
                }
            )
            OutlinedTextField(
                modifier = Modifier.padding(2.dp),
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Confirm Password") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = White,
                    focusedBorderColor = DarkBlue,
                    unfocusedBorderColor = Color.DarkGray,
                    focusedLabelColor = DarkBlue,
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.DarkGray,
                ),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = "Password Toggle"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {navController.navigate(CategoryScreen.EditProfile.route)},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DarkBlue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Edit Profile",
                    modifier = Modifier
                        .width(150.dp)
                        .height(20.dp),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,)
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = SkyBlue,
                    contentColor = Color.White
                ),
                modifier = Modifier.padding(2.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Sign out",
                    modifier = Modifier
                        .width(150.dp)
                        .height(20.dp),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,)
            }
        }
    }

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
    ) {

        Image(painter = painterResource(id = R.drawable.user),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop)

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}