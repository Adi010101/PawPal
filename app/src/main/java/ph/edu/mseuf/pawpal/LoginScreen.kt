package ph.edu.mseuf.pawpal

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ph.edu.mseuf.pawpal.MainActivity.Companion.TAG
import ph.edu.mseuf.pawpal.navigation.Screen
import ph.edu.mseuf.pawpal.ui.theme.DarkBlue



@Composable
fun SignInForm(navController: NavController, auth: Firebase) {
    val auth by lazy {
        Firebase.auth
    }
    val context = LocalContext.current

    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    Scaffold(backgroundColor = DarkBlue) {
        Column(Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            Image(
                painter = painterResource(id = R.drawable.adoption_w),
                contentDescription = "App Logo",
                modifier = Modifier
                    .weight(1f)
                    .size(200.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Card(
                Modifier
                    .weight(2f)
                    .padding(8.dp),
                shape = RoundedCornerShape(32.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Text(text = "Welcome Back!", fontWeight = FontWeight.Bold, fontSize = 32.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Look for your next Pal", fontWeight = FontWeight.Thin, fontSize = 20.sp)
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Spacer(modifier = Modifier.height(9.dp))

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = username,
                            onValueChange = { username = it },
                            label = { Text(text = "Username") },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = DarkBlue,
                                unfocusedBorderColor = Color.DarkGray,
                                focusedLabelColor = DarkBlue,
                                unfocusedLabelColor = Color.DarkGray,
                                cursorColor = Color.DarkGray,
                            ) ,
                            singleLine = true,
                            trailingIcon = {
                                if (username.isNotBlank())
                                    IconButton(onClick = { username = "" }) {
                                        Icon(
                                            imageVector = Icons.Filled.Clear,
                                            contentDescription = ""
                                        )
                                    }
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "Password") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
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
                            onClick = {auth.signInWithEmailAndPassword(username,password)
                                .addOnCompleteListener {
                                    if (it.isSuccessful){
                                        Log.d(TAG, "The user has successfully logged in")
                                        navController.navigate(Screen.Home.route)
                                    } else {
                                        Log.d(TAG, "The user has failed to log in", it.exception)
                                        Toast.makeText(context, "Please enter correct username or password!", Toast.LENGTH_SHORT).show()
                                    }
                                }},
                            colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue, contentColor = Color.White),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(text = "Sign In")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row {
                            Text(text = "New to PawPal?", fontSize = 14.sp)
                            Text(
                                color = DarkBlue,
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.SemiBold,
                                text = " Sign-up",
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate("register_page")
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController  = rememberNavController()
    SignInForm(navController = navController, auth = Firebase)
}
