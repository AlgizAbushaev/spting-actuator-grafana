package ru.anabushaev.schedulleryandextaxi.repository

import io.micrometer.core.annotation.Timed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.anabushaev.schedulleryandextaxi.model.MomentPrice
import ru.anabushaev.schedulleryandextaxi.model.Price
@Repository
interface PriceRepository: JpaRepository<MomentPrice, Long> {
    @Timed("gettingAllPrices")
    override fun findAll(): MutableList<MomentPrice>
}
