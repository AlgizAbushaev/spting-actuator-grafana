package ru.anabushaev.schedulleryandextaxi.model

data class Coordinate(val longitude: String, val latitude: String) {

    override fun toString(): String {
        return longitude + "," + latitude
    }
}
