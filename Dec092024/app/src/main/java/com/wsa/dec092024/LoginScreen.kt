package com.wsa.dec092024

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview

fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current


    val customColor = Color(0xFF123456) // Replace with your desired hex code

// Use customColor in the background modifier
    var modifier = Modifier.background(customColor)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img), contentDescription = "Login page",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Login to your account")
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(value = email, onValueChange = {email=it}, label = {
            Text(text = "Email Address")
        }, visualTransformation = PasswordVisualTransformation() )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = password, onValueChange = {password=it}, label = {
            Text(text = "Password")
        })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Don't have an account?", modifier = Modifier.clickable {

        })
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Or sign in with")
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth().padding(40.dp),
            horizontalArrangement =Arrangement.SpaceEvenly )
        //horizontalArrangement = Arrangement.spacedBy(30.dp))
        {
            Image(painter = painterResource(R.drawable.facebook),
                contentDescription = "facebook",
                modifier = Modifier.size(50.dp).clickable {
                    //facebook login
                    val fbintent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com"))
                   context.startActivity(fbintent)
                })
            Image(painter = painterResource(R.drawable.snap),
                contentDescription = "Snapchat",
                modifier = Modifier.size(60.dp).clickable {
                    //Snapchat login
                    val snapintent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.snapchat.com/"))
                    context.startActivity(snapintent)
                })
            Image(painter = painterResource(R.drawable.twiter),
                contentDescription = "Twitter",
                modifier = Modifier.size(50.dp).clickable {
                    //twitter login
                    val xintent =Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.twitter.com"))
                    context.startActivity(xintent)
                })
            Image(painter = painterResource(R.drawable.insta),
                contentDescription = "Instagram",
                modifier = Modifier.size(50.dp).clickable {
                    //Instagram login
                    val instaintent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com"))
                    context.startActivity(instaintent)
                })

        }

    }
}
