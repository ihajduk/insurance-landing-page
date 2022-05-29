package eu.iwha.insurancelandingpage.adapter

import eu.iwha.insurancelandingpage.domain.User
import eu.iwha.insurancelandingpage.domain.UserId
import eu.iwha.insurancelandingpage.domain.UserRepository
import java.util.concurrent.ConcurrentHashMap

class InMemoryUserRepository(
    private val users: MutableMap<String, UserEntity> = ConcurrentHashMap()
): UserRepository {

    override fun getUser(userId: UserId): User {
        return users[userId.raw]?.toDomain() ?: throw UserNotFoundException(userId)
    }

    override fun addUser(user: User) {
        users[user.id.raw] = user.toEntity()
    }
}

data class UserEntity(
    val id: String,
    val name: String
)

private fun UserEntity.toDomain(): User = User(UserId(this.id), name)

private fun User.toEntity(): UserEntity = UserEntity(this.id.raw, name)
