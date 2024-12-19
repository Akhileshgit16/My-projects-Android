package com.wsa.foodlazycolumn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun FoodList(modifier: Modifier = Modifier)
{
    LazyColumnDemo()

}

@Composable
fun LazyColumnDemo()
{
    LazyColumn {
        itemsIndexed(items = getAllFoodClass(), itemContent = {index, item -> FoodItem(item=item) })
    }
}


@Composable
fun FoodItem(item: FoodsClass, modifier: Modifier = Modifier) {
    Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
        )


        {

            Row(modifier = Modifier.fillMaxSize().background(color = Color.Black))

            {

                Image(
                    painter = painterResource(id = item.foodimages),
                    contentDescription = item.foodname,
                    Modifier.padding(16.dp).size(150.dp).border(
                        BorderStroke(width = 4.dp, Color.Cyan),
                        CircleShape
                    ).clip(CircleShape).align(
                        Alignment.CenterVertically
                    )
                )


                Column(
                    modifier = Modifier.fillMaxSize().padding(8.dp)
                        .align(Alignment.CenterVertically),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = item.foodname,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 24.sp,
                            fontStyle = FontStyle.Italic,
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = item.fooddetails,
                        style = TextStyle(
                            color = Color.Cyan, fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = item.foodchains,
                        style = TextStyle(color = Color.LightGray, fontSize = 18.sp)
                    )
                }
            }
        }

    }
