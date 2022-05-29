package eu.iwha.insurancelandingpage.domain

interface UserRepository {
    fun getUser(userId: UserId): User
    fun addUser(user: User)
}

@JvmInline
value class UserId(val raw: String)

data class User(val id: UserId, val name: String)