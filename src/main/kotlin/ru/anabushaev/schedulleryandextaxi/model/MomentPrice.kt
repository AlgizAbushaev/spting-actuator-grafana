package ru.anabushaev.schedulleryandextaxi.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "moment_price")
data class MomentPrice(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val date: LocalDateTime,
    val price: Double
)