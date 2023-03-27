package com.example.nippon_desu.ui.components

import android.media.MediaPlayer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nippon_desu.R


/*Japones audio para saludar y despedir*/
private lateinit var mediaPlayer: MediaPlayer
@Composable
fun Greeting(greeting:()->Unit) {
    mediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.okaeri)
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 12.dp),
        backgroundColor = Color.Green,
        modifier = Modifier.padding(5.dp).clickable{
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            mediaPlayer.start()
        }
    ) {
        Row(
            modifier = Modifier.padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "おかえりなさい",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPrev() {
    Greeting(){}
}