package com.example.nippon_desu.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.nippon_desu.R
import com.example.nippon_desu.modelo.Product


@Composable
fun ProductScreen(product: Product, navController: NavController, addCart: ()-> Unit) {
    Box {
        if (product.image_url != null){
            AsyncImage(
                model = product.image_url,
                contentDescription = "background image",
                modifier = Modifier
                    .fillMaxHeight(.7F)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        }else{
            Image(
                painter = painterResource(id = R.drawable.onigiri),
                contentDescription = "background image",
                modifier = Modifier
                    .fillMaxHeight(.7F)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        }
        Scaffold(backgroundColor = Color.Transparent,
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
                    actions = {
                        IconButton(onClick = { navController.navigate("cart") }) {
                            Icon(
                                imageVector = Icons.Outlined.ShoppingCart,
                                contentDescription = "shopping cart icon"
                            )
                        }
                    },
                    backgroundColor = Color.Transparent,
                    contentColor = Color.White
                )
            },
            content = {
                Box(modifier = Modifier.padding(it))

            },
            bottomBar = {
                Card(
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                    modifier = Modifier
                        .fillMaxWidth(1F)
                        .fillMaxHeight(.5F)
                        .clickable { },
                    elevation = 10.dp
                ) {
                    Column(Modifier.padding(horizontal = 20.dp, vertical = 50.dp)) {
                        Row() {
                            Text(
                                text = product.name,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.fillMaxWidth(.75F),
                                color = Color.Black
                            )
                            Text(
                                text = "$${product.price}",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Green,
                                modifier = Modifier.fillMaxWidth(1F)

                            )
                        }
                        Text(
                            text = product.desc?:"There is no description for this product",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(vertical = 25.dp),
                            color = Color.Black

                        )
                        Button(
                            onClick = {addCart()},
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 50.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                "Add to cart",
                                color = Color.White,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                    }


                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    /*ProductScreen()*/

}