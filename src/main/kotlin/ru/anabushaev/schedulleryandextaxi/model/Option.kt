package ru.anabushaev.schedulleryandextaxi.model

data class Option(
    val class_level: Int,
    val class_name: String,
    val class_text: String,
    val min_price: Int,
    val price: Double,
    val price_text: String,
    val waiting_time: String
)
