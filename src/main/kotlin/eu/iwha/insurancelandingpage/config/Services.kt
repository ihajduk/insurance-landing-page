package eu.iwha.insurancelandingpage.config

import eu.iwha.insurancelandingpage.InsuranceFacade
import eu.iwha.insurancelandingpage.adapter.InMemoryUserRepository
import eu.iwha.insurancelandingpage.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Services {

    @Bean
    fun userRepository(): UserRepository = InMemoryUserRepository()

    @Bean
    fun insuranceFacade(userRepository: UserRepository): InsuranceFacade {
        return InsuranceFacade(userRepository)
    }
}