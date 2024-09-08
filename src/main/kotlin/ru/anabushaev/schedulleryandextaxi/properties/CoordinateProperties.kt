package ru.anabushaev.schedulleryandextaxi.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "coordinate")
data class CoordinateProperties(
    var startLongitude: String = "",
    var startLatitude: String = "",
    var finishLatitude: String = "",
    var finishLongitude: String = ""
)
