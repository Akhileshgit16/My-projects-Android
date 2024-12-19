package com.wsa.dec12logindb

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.database.FirebaseDatabase



@Preview
@Composable
fun Myapp()
{
    MaterialTheme {Surface(Modifier.fillMaxHeight().padding(16.dp)){ LoginScreen()} }
}

@Preview
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    // States to hold input data
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Firebase Database reference (initiate once)
    val database = FirebaseDatabase.getInstance().getReference("Users")
    val context= LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title Text
        Text(text = "Login to your account",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)

        )
        Spacer(modifier = Modifier.height(5.dp))

        // Name TextField
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        // Email TextField
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email Address") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,

        )

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(5.dp))
        // Submit Button
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Button(onClick = {
                val user = Loginclass(
                    username = name,
                    emailid = email,
                    loginpassword = password
                )

                // Push data to Firebase
                database.push().setValue(user).addOnCompleteListener {
                    if (it.isSuccessful) {
                       Toast.makeText(context,"Add data successfully",Toast.LENGTH_SHORT).show()
                        name=""
                        email = ""
                        password = ""
                    } else {
                       Toast.makeText(context,"Failed to add data",Toast.LENGTH_SHORT).show()
                    }
                }

            })
            {
                Text(text = "SUBMIT")
            }
        }
    }
}
