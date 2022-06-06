package eu.iwha.insurancelandingpage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class InsuranceLandingPageApplication

fun main(args: Array<String>) {
    val appContext = runApplication<InsuranceLandingPageApplication>(*args)
    appContext.start()
}
