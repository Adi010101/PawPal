package ph.edu.mseuf.pawpal

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ph.edu.mseuf.pawpal.ui.theme.DarkBlue



@Composable
fun SignUpForm(navController: NavController) {
    val context = LocalContext.current
    val nameVal = remember { mutableStateOf("") }
    val emailVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val confirmPasswordVal = remember { mutableStateOf("") }

    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    var confirmPasswordVisibility by remember {
        mutableStateOf(false)
    }

    val auth = Firebase.auth


    Scaffold(backgroundColor = DarkBlue) {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
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
                    .weight(3f)
                    .padding(8.dp),
                shape = RoundedCornerShape(32.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                ) {
                    Text(text = "Create Account", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Looks like you're new here!", fontWeight = FontWeight.Thin, fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
                    {
                        OutlinedTextField(
                            value = nameVal.value,
                            onValueChange = { nameVal.value = it },
                            label = { Text(text = "Name") },
                            placeholder = { Text(text = "Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = DarkBlue,
                                unfocusedBorderColor = DarkGray,
                                focusedLabelColor = DarkBlue,
                                unfocusedLabelColor = DarkGray,
                                cursorColor = DarkGray,
                            ),
                        )

                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address") },
                            placeholder = { Text(text = "Email Address") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = DarkBlue,
                                unfocusedBorderColor = DarkGray,
                                focusedLabelColor = DarkBlue,
                                unfocusedLabelColor = DarkGray,
                                cursorColor = DarkGray,
                            ),
                        )

                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = DarkBlue,
                                unfocusedBorderColor = DarkGray,
                                focusedLabelColor = DarkBlue,
                                unfocusedLabelColor = DarkGray,
                                cursorColor = DarkGray,
                            ),
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                                    Icon(
                                        imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = "Password Toggle"
                                    )
                                }
                            }
                        )

                        OutlinedTextField(
                            value = confirmPasswordVal.value,
                            onValueChange = { confirmPasswordVal.value = it },
                            label = { Text(text = "Confirm Password") },
                            placeholder = { Text(text = "Password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = DarkBlue,
                                unfocusedBorderColor = DarkGray,
                                focusedLabelColor = DarkBlue,
                                unfocusedLabelColor = DarkGray,
                                cursorColor = DarkGray,
                            ),
                            visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                                    Icon(
                                        imageVector = if (confirmPasswordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = "Password Toggle"
                                    )
                                }
                            }
                        )

                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(
                            onClick = {
                               /* if (nameVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter the name!", Toast.LENGTH_SHORT).show()
                                } else if (emailVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter the email address!", Toast.LENGTH_SHORT).show()
                                } else if (passwordVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter password!", Toast.LENGTH_SHORT).show()
                                } else if (confirmPasswordVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter confirm password!", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "Successfully Registered!", Toast.LENGTH_SHORT).show() */
                                    auth.createUserWithEmailAndPassword(
                                        emailVal.value.trim(),
                                        passwordVal.value.trim()
                                    )
                                        .addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Toast.makeText(context, "Successfully Registered!", Toast.LENGTH_SHORT).show()
                                            } else {
                                                if (nameVal.value.isEmpty()) {
                                                    Toast.makeText(context, "Please enter the name!", Toast.LENGTH_SHORT).show()
                                                } else if (emailVal.value.isEmpty()) {
                                                    Toast.makeText(context, "Please enter the email address!", Toast.LENGTH_SHORT).show()
                                                } else if (passwordVal.value.isEmpty()) {
                                                    Toast.makeText(context, "Please enter password!", Toast.LENGTH_SHORT).show()
                                                } else if (confirmPasswordVal.value.isEmpty()) {
                                                    Toast.makeText(context, "Please enter confirm password!", Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue, contentColor = Color.White),
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Text(text = "Sign Up")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row {
                            Text(text = "Already have an account?", fontSize = 14.sp)
                            Text(
                                color = DarkBlue,
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.SemiBold,
                                text = " Sign-in",
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate("login_page")
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
fun SignUpPreview() {
    val navController  = rememberNavController()
    SignUpForm(navController = navController)
}