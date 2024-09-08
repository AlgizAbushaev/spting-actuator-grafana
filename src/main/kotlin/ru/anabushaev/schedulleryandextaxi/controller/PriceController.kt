package ru.anabushaev.schedulleryandextaxi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.anabushaev.schedulleryandextaxi.model.MomentPrice
import ru.anabushaev.schedulleryandextaxi.service.TaxiService

@RestController
class PriceController(private val taxiService: TaxiService) {

    @GetMapping("/prices")
    fun getAllPrice(): MutableList<MomentPrice> {
        return taxiService.getAllPrice()
    }
}