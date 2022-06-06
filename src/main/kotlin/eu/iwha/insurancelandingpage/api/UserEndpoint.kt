package eu.iwha.insurancelandingpage.api

import eu.iwha.insurancelandingpage.InsuranceFacade
import eu.iwha.insurancelandingpage.domain.CreateUserCommand
import eu.iwha.insurancelandingpage.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(("/users"))
class UserEndpoint(private val insuranceFacade: InsuranceFacade) {

    @GetMapping("/{userId}")
    fun getUser(@PathVariable("userId") userId: String): UserJson =
        insuranceFacade.getUser(userId).toJson()

    @PostMapping
    fun addUser(@RequestBody createUser: CreateUserJson) =
        insuranceFacade.addUser(createUser.toDomain())
}

data class CreateUserJson(val name: String)

data class UserJson(val id: String, val name: String)

private fun User.toJson() = UserJson(this.id.raw, this.name)

private fun CreateUserJson.toDomain(): CreateUserCommand = CreateUserCommand(this.name)
