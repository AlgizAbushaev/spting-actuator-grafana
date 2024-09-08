package ru.anabushaev.schedulleryandextaxi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@EnableFeignClients
@EnableScheduling
@EnableJpaRepositories
@SpringBootApplication
@EnableConfigurationProperties
class SchedullerYandexTaxiApplication

fun main(args: Array<String>) {
	runApplication<SchedullerYandexTaxiApplication>(*args)
}
