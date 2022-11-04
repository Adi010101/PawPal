package ph.edu.mseuf.pawpal

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.android.material.datepicker.MaterialDatePicker
import ph.edu.mseuf.pawpal.ui.theme.DarkBlue
import ph.edu.mseuf.pawpal.ui.theme.Grayish
import ph.edu.mseuf.pawpal.ui.theme.White
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ScheduleFormScreen() {
    var name by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var date by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(text = "Schedule", fontWeight = FontWeight.Bold,color = Grayish, fontSize = 32.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Fill up the form for the schedule of the adoption of your new friend.", fontWeight = FontWeight.Thin,color = Grayish, fontSize = 15.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
        ){
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
            value = phone,
            onValueChange = { phone = it },
            label = { Text(text = "Phone Number") },
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
                if (phone.isNotBlank())
                    IconButton(onClick = { phone = "" }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = ""
                        )
                    }
            }
        )
       OutlinedTextField(
            modifier = Modifier.padding(2.dp),
            value = date,
            onValueChange = { date = it },
            label = { Text(text = "mm/dd/yyyy") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = White,
                focusedBorderColor = DarkBlue,
                unfocusedBorderColor = Color.DarkGray,
                focusedLabelColor = DarkBlue,
                unfocusedLabelColor = Color.DarkGray,
                cursorColor = Color.DarkGray,
            ),
            singleLine = true,
            trailingIcon = { Icon(imageVector = Icons.Default.CalendarToday, contentDescription = "nameIcon") },

        )
       Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = DarkBlue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(text = "Schedule",
                modifier = Modifier.width(150.dp).height(20.dp),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,)
            }
        }
    }
}






@Preview(showBackground = true)
@Composable
fun ScheduleFormScreenPreview() {
    ScheduleFormScreen()
}