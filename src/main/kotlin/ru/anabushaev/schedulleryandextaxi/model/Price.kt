package ru.anabushaev.schedulleryandextaxi.model

data class Price(
    val currency: String,
    val distance: Double,
    val options: MutableList<Option>,
    val time: String
)
