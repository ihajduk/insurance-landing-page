package eu.iwha.insurancelandingpage.shared

import eu.iwha.insurancelandingpage.adapter.postgres.UserEntity
import eu.iwha.insurancelandingpage.domain.User
import eu.iwha.insurancelandingpage.domain.UserId

fun UserEntity.toDomain(): User = User(UserId(this.id ?: ""), name) //todo: delete id from read model

fun User.toEntity(): UserEntity = UserEntity(this.id.raw, name)