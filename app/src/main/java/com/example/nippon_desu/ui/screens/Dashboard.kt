package com.example.nippon_desu.ui.components

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.nippon_desu.MainActivity
import com.example.nippon_desu.R
import com.example.nippon_desu.modelo.Product
import com.example.nippon_desu.ui.theme.NippondesuTheme
@Composable
fun Dashboard(list: List<Product>, navController: NavHostController) {
    var locallist = list
    var textState = remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Greeting{
                } },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                actions = {
                    IconButton(onClick = { navController.navigate("cart") }) {
                        Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "")
                    }
                },
                modifier = Modifier.padding(10.dp, 40.dp, 10.dp, 10.dp)

            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(10.dp, 40.dp)
            ) {
                SearchView(state = textState) {}
                Spacer(modifier = Modifier.width(width = 20.dp))
                LazyRow(Modifier.padding(horizontal = 10.dp, vertical = 40.dp)) {
                    items(items = locallist, itemContent = { item ->
                        ProductView(item, navController)
                        Spacer(modifier = Modifier.width(width = 20.dp))
                    })
                }
            }

        }
    )

}


@Preview(showBackground = true)
@Composable
fun DashboardPrev() {
    /*NippondesuTheme() {
        val products = listOf(
            Product(name = "Onigiri", price = 10.0, image_url = "https://top.his-usa.com/destination-japan/up_img/cke/imgs/20171122/sushi.jpg"),
            Product(name = "Onigiri", price = 10.0),
            Product(name = "Onigiri", price = 10.0)
        )
        Dashboard("Medellin, Antioquia",products)
    }*/
}