package eu.iwha.insurancelandingpage.config

import eu.iwha.insurancelandingpage.domain.User
import eu.iwha.insurancelandingpage.domain.UserId
import eu.iwha.insurancelandingpage.domain.UserRepository
import mu.KotlinLogging
import org.springframework.context.event.ContextStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class OnLocalStartup(private val userRepository: UserRepository) {
    private val logger = KotlinLogging.logger {}

    @EventListener
    fun onApplicationEvent(event: ContextStartedEvent) {
        val sampleUser = User(UserId("1"), "Jan")
        logger.info { "Creating sample user $sampleUser" }
        userRepository.addUser(sampleUser)
    }
}