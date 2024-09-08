package ru.anabushaev.schedulleryandextaxi.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "yandex")
data class YandexProperties(
    var clid: String = "",
    var apiKey: String = ""
)
