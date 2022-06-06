package eu.iwha.insurancelandingpage.config

import mu.KotlinLogging
import org.springframework.context.event.ContextStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class OnLocalStartup {
    private val logger = KotlinLogging.logger {}

    @EventListener
    fun onApplicationEvent(event: ContextStartedEvent) {
        logger.info { "App started lol." }
    }
}