package eu.iwha.insurancelandingpage.adapter.postgres

import eu.iwha.insurancelandingpage.adapter.UserNotFoundException
import eu.iwha.insurancelandingpage.domain.CreateUserCommand
import eu.iwha.insurancelandingpage.domain.User
import eu.iwha.insurancelandingpage.domain.UserId
import eu.iwha.insurancelandingpage.domain.UserRepository
import eu.iwha.insurancelandingpage.shared.toDomain

class DatabaseUserRepository(private val postgresUserRepository: PostgresUserRepository): UserRepository {
    override fun getUser(userId: UserId): User {
        return postgresUserRepository.findById(userId.raw)?.toDomain() ?: throw UserNotFoundException(userId)
    }

    override fun addUser(createUserCommand: CreateUserCommand): User {
        return postgresUserRepository.save(createUserCommand.toEntity()).toDomain()
    }
}

private fun CreateUserCommand.toEntity(): UserEntity = UserEntity(name = this.name)
