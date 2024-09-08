package ru.anabushaev.schedulleryandextaxi.scheduller

import io.micrometer.core.annotation.Timed
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.anabushaev.schedulleryandextaxi.model.Coordinate
import ru.anabushaev.schedulleryandextaxi.properties.CoordinateProperties
import ru.anabushaev.schedulleryandextaxi.service.TaxiService

@Service
class YandexSheduller(
    private val coordinateProperties: CoordinateProperties,
    private val taxiService: TaxiService
) {

    @Timed("schedullerTaxi")
    @Scheduled(fixedDelay = 30_000)
    fun updatePrice() {
        val startPoint = Coordinate(coordinateProperties.startLongitude, coordinateProperties.startLatitude)
        val endPoint = Coordinate(coordinateProperties.finishLatitude, coordinateProperties.finishLatitude)
        taxiService.getPrice(startPoint, endPoint)
    }
}