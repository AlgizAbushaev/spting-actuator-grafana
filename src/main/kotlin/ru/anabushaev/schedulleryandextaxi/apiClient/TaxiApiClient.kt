package ru.anabushaev.schedulleryandextaxi.apiClient

import io.micrometer.core.annotation.Timed
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import ru.anabushaev.schedulleryandextaxi.model.Price

@FeignClient(name = "yandexclient", url = "\${yandex.url}")
interface TaxiApiClient {

    @Timed("gettingPriceFromYandex")
    @GetMapping
    fun getPrice(
        @RequestParam clid: String,
        @RequestParam apiKey: String,
        @RequestParam rll: String
    ): Price
}
