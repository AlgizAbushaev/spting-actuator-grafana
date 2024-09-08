package ru.anabushaev.schedulleryandextaxi.service

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Service
import ru.anabushaev.schedulleryandextaxi.apiClient.TaxiApiClient
import ru.anabushaev.schedulleryandextaxi.model.Coordinate
import ru.anabushaev.schedulleryandextaxi.model.MomentPrice
import ru.anabushaev.schedulleryandextaxi.properties.YandexProperties
import ru.anabushaev.schedulleryandextaxi.repository.PriceRepository
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.concurrent.atomic.AtomicInteger

@Service
class TaxiService(
    private val yandexProperties: YandexProperties,
    private val taxiApiClient: TaxiApiClient,
    private val priceRepository: PriceRepository,
    private val meterRegistry: MeterRegistry
) {

    private val price = AtomicInteger()
    init {
        meterRegistry.gauge("priceTaxi", price)
    }
    fun getPrice(startPoint: Coordinate, endPoint: Coordinate) {
        val rll = startPoint.toString() + "~" + endPoint.toString()
        val clid = yandexProperties.clid
        val apiKey = yandexProperties.apiKey

        val currentPrice = taxiApiClient.getPrice(clid, apiKey, rll)
        if (currentPrice.options.isEmpty()) throw RuntimeException("Options are empty")

        var priceDouble = currentPrice.options.get(0).price
        price.set(priceDouble.toInt())
        var momentPrice = MomentPrice(
            date = LocalDateTime.now(ZoneId.of("Europe/Moscow")),
            price = priceDouble
        )

        priceRepository.save(momentPrice)
    }

    fun getAllPrice(): MutableList<MomentPrice> {
        return priceRepository.findAll()
    }


}
