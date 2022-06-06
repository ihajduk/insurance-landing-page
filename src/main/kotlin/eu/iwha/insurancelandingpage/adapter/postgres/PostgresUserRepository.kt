package eu.iwha.insurancelandingpage.adapter.postgres

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.repository.Repository

interface PostgresUserRepository : Repository<UserEntity, String> {
    fun findById(id: String): UserEntity?
    fun save(userEntity: UserEntity): UserEntity
}

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    val id: String? = null,
    val name: String
)