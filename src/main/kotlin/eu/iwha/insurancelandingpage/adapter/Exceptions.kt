package eu.iwha.insurancelandingpage.adapter

import eu.iwha.insurancelandingpage.domain.UserId

class UserNotFoundException(userId: UserId) : RuntimeException("User $userId not found")