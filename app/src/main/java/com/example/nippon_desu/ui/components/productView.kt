package com.example.nippon_desu.ui.components

import android.content.res.Resources.Theme
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.nippon_desu.R
import com.example.nippon_desu.modelo.Product
import com.google.gson.Gson
import com.google.gson.GsonBuilder

@Composable
fun ProductView(product: Product, navController: NavHostController) {
    Card(
        shape = RoundedCornerShape(size = 20.dp),
        modifier = Modifier
            .width(240.dp)
            .clickable {
                navController.navigate("product/${product.id}",)
            },
        elevation = 10.dp
    ) {
        Box(Modifier.fillMaxSize()){
            if (product.image_url != null){
                AsyncImage(
                    model =product.image_url,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }else{
                Image(
                    painter = painterResource(id = R.drawable.onigiri),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }


            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            verticalArrangement = Arrangement.Bottom) {
                Text(
                    product.name,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFF14C18),
                    modifier = Modifier.padding(top = 10.dp),
                    fontSize = 32.sp,
                )
                Text(
                    text = "$ ${product.price}",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFF14C18),
                    modifier = Modifier.padding(top = 10.dp),
                    fontSize = 16.sp
                )
            }

        }

    }
}

@Composable
fun ProductViewCart(name: String, price: Double, image_url: String?) {
    Card(
        elevation = 4.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Row(
            modifier = Modifier.padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (image_url != null){
                AsyncImage(
                    model = image_url,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(62.dp),
                    contentScale = ContentScale.Crop
                )
            }else{
                Image(
                    painter = painterResource(id = R.drawable.onigiri),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(62.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth(.75f)
                    .padding(start = 5.dp),
                color = Color.Black

            )
            Text(
                text = "$ ${price}",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(start = 5.dp),
                color = Color.Black

            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPrev() {
    /*ProductView(
        "Onigiri",
        10.0,
        "https://top.his-usa.com/destination-japan/up_img/cke/imgs/20171122/sushi.jpg"
    )*/
    //ProductViewCart(name = "Onigiri", price = 10.0)
}