package ro.asis.green.account.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication()
class GreenAccountServiceApplication

fun main(args: Array<String>) {
    runApplication<GreenAccountServiceApplication>(*args)
}
