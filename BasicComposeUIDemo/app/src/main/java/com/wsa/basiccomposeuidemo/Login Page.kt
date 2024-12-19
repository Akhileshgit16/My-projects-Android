package com.wsa.basiccomposeuidemo

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun Image(painter: Painter) {

}

@Composable
@Preview
fun LoginPage(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }





    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {

        Row(
            horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        )
        {

            Image(
                painter = painterResource(R.drawable.donout),
                contentDescription = "Donuts",
                modifier = Modifier.padding(5.dp).height(80.dp).width(80.dp)
            )
            Image(
                painter = painterResource(R.drawable.andriod_oreo),
                contentDescription = "oreo",
                modifier = Modifier.padding(5.dp).height(80.dp).width(80.dp))
            Image(
                painter = painterResource(R.drawable.android_honeycomb),
                contentDescription = "honeycomb",
                modifier = Modifier.padding(5.dp).height(80.dp).width(80.dp)
            )
            Image(
                painter = painterResource(R.drawable.froyo),
                contentDescription = "froyo",
                modifier = Modifier.padding(5.dp).height(80.dp).width(80.dp)
            )
        }

        OutlinedTextField(value = email, onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email Id") })

        OutlinedTextField(value = password, onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Password") })

        Row(
            horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        )
        {
            Button(onClick = { /*TODO*/ }) { Text(text = "Sign up") }
            Button(
                onClick = { Log.e("Login Details", "Email: $email, Password: $password") },
                modifier = Modifier.padding(start = 4.dp)
            )
            { Text(text = "Login") }

        }

        Row(horizontalArrangement = Arrangement.Start,modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.icecream_sandwich),
                contentDescription = "Ice Cream Sandwich",
                modifier = Modifier.padding(5.dp).height(80.dp).width(80.dp)
            )

            Image(
                painter = painterResource(R.drawable.lollypop),
                contentDescription = "Lollypop",
                modifier = Modifier.padding(5.dp).height(100.dp).width(100.dp)
            )
            Image(
                painter = painterResource(R.drawable.kitkat),
                contentDescription = "kitkat",
                modifier = Modifier.padding(5.dp).height(100.dp).width(100.dp)
            )
            Image(
                painter = painterResource(R.drawable.eclairs),
                contentDescription = "eclairs",
                modifier = Modifier.padding(5.dp).height(100.dp).width(100.dp)
            )



        }
    }



}