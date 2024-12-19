package com.wsa.basiccomposeuidemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wsa.basiccomposeuidemo.ui.theme.BasicComposeUIDemoTheme

class MainActivity : ComponentActivity() {

       override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {

                LoginPage()
               /*
                Text(
                    text = "Hey Dude How is it going, All Set for Long Weekend",
                    fontSize = "30sp",
                    fontWeight = "Bold",
                    fontStyle = "Italic",
                    color = Color.Red
                )

                Row {
                    ElevatedButton(onClick = { /*TODO*/ }) {
                        Text("Click Me")


                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.icecream_sandwich), // Replace with your image resource
                        contentDescription = "Icecream Sandwich Image",
                        alignment = Alignment.Center // Space between the image and text
                    )
                }


                */

            }

        }

    }
