package com.example.nippon_desu

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nippon_desu.modelo.Product
import com.example.nippon_desu.modelo.products
import com.example.nippon_desu.ui.components.Dashboard
import com.example.nippon_desu.ui.screens.CartScreen
import com.example.nippon_desu.ui.screens.ProductScreen
import com.example.nippon_desu.ui.theme.NippondesuTheme
import com.google.gson.Gson
import com.google.gson.GsonBuilder
val cart = mutableListOf<Product>()

private lateinit var mediaPlayer: MediaPlayer
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        mediaPlayer = MediaPlayer.create(this, R.raw.background_sound)
        super.onCreate(savedInstanceState)
        setContent {
            mediaPlayer.setVolume(.2F,.2F)
            mediaPlayer.isLooping = true
            mediaPlayer.start()
            val navController = rememberNavController()
            NippondesuTheme {
                NavHost(navController = navController, startDestination = "dashboard") {
                    composable("dashboard") {
                        Dashboard(
                            list = products,
                            navController
                        )
                    }
                    composable("product/{item}") {
                        val actualProduct = products.find{ product -> product.id == it.arguments?.getString("item")}!!
                        ProductScreen(actualProduct,navController) {
                            cart.add(actualProduct)
                        }
                    }
                    composable("cart") {
                        CartScreen(cart,navController){
                            cart.removeAll(cart)
                        }
                    }
                }
            }

        }

    }

    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.seekTo(0)
        super.onDestroy()
    }


}


@Composable
fun Greeting(name: String) {

    //Dashboard(location = "Medellin, Antioquia", list = products)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NippondesuTheme {
        Greeting(name = "shiit")
    }
}