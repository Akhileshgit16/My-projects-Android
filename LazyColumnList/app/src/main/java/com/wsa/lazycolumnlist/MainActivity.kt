package com.wsa.lazycolumnlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wsa.lazycolumnlist.ui.theme.LazyColumnListTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
             val crickersList = listOf("Virat Kohli", "Rohit Sharma","David Warner" ,"Steve Smith", "Kane Williamson", "Chris Galye",
                "Kapil Dev","Anil Kumble", "Shikhar Dhawan","Don Bradman","Ricky Ponting","Babar Azam","Ben Stokes",
                "Kevin Pietersen","Joe Root","James Anderson","Alastair Cook","Shane Warne","Glenn McGrath","Imran Khan",
                "Wasim Akram","Shahid Afridi","AB de Villiers","Graeme Smith","Dale Steyn","Sir Vivian Richards",
                "Brian Lara"        )

            CrickerlistDemo(crickersList)
        }
    }
}
@Composable
fun CrickerlistDemo(crickersList: List<String>) {
    LazyColumn(Modifier.fillMaxWidth().padding(16.dp)) {
        items(crickersList){
            Text(text = it, style = TextStyle(color = Color.Magenta, fontSize = 30.sp ,fontStyle = FontStyle.Italic))
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

