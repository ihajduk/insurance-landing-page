package eu.iwha.insurancelandingpage

import eu.iwha.insurancelandingpage.domain.User
import eu.iwha.insurancelandingpage.domain.UserId
import eu.iwha.insurancelandingpage.domain.UserRepository

class InsuranceFacade(private val userRepository: UserRepository) {

    fun getUser(userId: String): User = userRepository.getUser(UserId(userId))
}