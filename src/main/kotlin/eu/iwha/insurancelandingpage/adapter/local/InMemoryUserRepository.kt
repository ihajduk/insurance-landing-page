package eu.iwha.insurancelandingpage.adapter.local

import eu.iwha.insurancelandingpage.adapter.UserNotFoundException
import eu.iwha.insurancelandingpage.adapter.postgres.UserEntity
import eu.iwha.insurancelandingpage.domain.CreateUserCommand
import eu.iwha.insurancelandingpage.domain.User
import eu.iwha.insurancelandingpage.domain.UserId
import eu.iwha.insurancelandingpage.domain.UserRepository
import eu.iwha.insurancelandingpage.shared.toDomain
import eu.iwha.insurancelandingpage.shared.toEntity
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

class InMemoryUserRepository(
    private val users: MutableMap<String, UserEntity> = ConcurrentHashMap()
): UserRepository {

    override fun getUser(userId: UserId): User {
        return users[userId.raw]?.toDomain() ?: throw UserNotFoundException(userId)
    }

    override fun addUser(createUserCommand: CreateUserCommand): User {
        val id = UUID.randomUUID().toString()
        val user = User(UserId(id), createUserCommand.name)
        users[id] = user.toEntity()
        return user
    }

    fun addUser(user: User) {
        users[user.id.raw] = user.toEntity()
    }
}