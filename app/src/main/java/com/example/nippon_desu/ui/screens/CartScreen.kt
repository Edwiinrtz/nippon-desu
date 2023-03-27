package com.example.nippon_desu.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nippon_desu.R
import com.example.nippon_desu.modelo.Product
import com.example.nippon_desu.modelo.products
import com.example.nippon_desu.ui.components.ProductViewCart
import java.text.DecimalFormat
import kotlin.math.roundToInt
private lateinit var mediaPlayer: MediaPlayer
@Composable
fun CartScreen(cart:List<Product>, navController: NavController, checkOut:()->Unit) {
    mediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.arigatou)
    mediaPlayer.setVolume(2F,2F)
    var subtotal = 0.0
    val df = DecimalFormat("#.#")
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Go back arrow"
                        )
                    }
                },
                backgroundColor = Color.Transparent,
                contentColor = Color.Black
            )
            Spacer(modifier = Modifier.padding(15.dp))
        }, bottomBar = {
            Card(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.35F),
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                elevation = 25.dp
            ) {
                Column() {
                    Row(Modifier.padding(25.dp)) {
                        Column(
                            Modifier
                                .fillMaxWidth(.75F)
                                .padding()
                        ) {
                            Text(text = "Subtotal", color = Color.Gray, fontSize = 15.sp)
                            Text(text = "Taxes", color = Color.Gray, fontSize = 15.sp)
                        }
                        Column(Modifier.fillMaxWidth(1F)) {
                            cart.map { product -> subtotal += product.price }
                            Text(
                                text = "$ $subtotal",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp,
                                modifier = Modifier.fillMaxWidth(1F),
                                textAlign = TextAlign.End,
                                color = Color.Black

                            )
                            Text(
                                text = "$ ${df.format(subtotal * .19)}",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp,
                                modifier = Modifier.fillMaxWidth(1F),
                                textAlign = TextAlign.End,
                                color = Color.Black
                            )
                        }
                    }
                    Divider(
                        color = Color.Black,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 25.dp)
                    )
                    Row(Modifier.padding(25.dp)) {
                        Column(
                            Modifier
                                .fillMaxWidth(.75F)
                                .padding()
                        ) {
                            Text(text = "Total", color = Color.Black, fontSize = 15.sp)
                        }
                        Column(Modifier.fillMaxWidth(1F)) {
                            Text(
                                text = "$ ${df.format(subtotal+subtotal*.19)}",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp,
                                modifier = Modifier.fillMaxWidth(1F),
                                textAlign = TextAlign.End,
                                color = Color.Black


                            )
                        }
                    }
                    Button(
                        onClick = {

                            if(mediaPlayer.isPlaying){
                                mediaPlayer.pause()
                                mediaPlayer.seekTo(0)
                            }
                            if(cart.isNotEmpty())mediaPlayer.start()
                            checkOut()
                            navController.navigate("dashboard")
                                  },
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp, start = 25.dp, end = 25.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            "Checkout",
                            color = Color.White,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }

            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxHeight(.7F)
        ) {
            items(items = cart, itemContent = { product ->
                ProductViewCart(product.name, product.price, product.image_url)
            })
        }


    }
}

@Preview
@Composable
fun CartScreenPreview() {
    //CartScreen()
}