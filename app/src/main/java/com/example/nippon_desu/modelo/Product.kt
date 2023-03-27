package com.example.nippon_desu.modelo


data class Product(
    val id:String,
    val name:String,
    val price:Double,
    val desc: String?=null,
    val image_url: String? = null

)


val products = listOf(
    Product(
        id="1",
        name = "Onigiri",
        price = 10.0,
        desc = "Onigiri también conocido como Omusubi es un plato japonés que consiste en una bola de arroz rellena o mezclada con otros ingredientes. Suele tener forma triangular u oval, y a veces está envuelta en una pequeña tira de alga nori.",
    ),
    Product(
        id="2",
        name = "Sushi",
        price = 8.0,
        desc = "One of the first Japanese foods that come to mind when Japan is mentioned is probably sushi. And why wouldn't it be? Sushi is widely available in many countries throughout the globe, and is commonly associated with Japan.",
        image_url = "https://top.his-usa.com/destination-japan/up_img/cke/imgs/20171122/sushi.jpg"
    ),
    Product(
        id="3",
        name = "Ramen",
        price = 15.0,
        desc = "Ramen is another dish that is very popular in Japan. Although the origins of ramen are unclear, some say it has its roots in China. The Japanese ramen that is well-loved today has become an entity of its own and is much different in flavor.",
        image_url = "https://top.his-usa.com/destination-japan/up_img/cke/imgs/20171122/ramen.jpg"
    )
)