package eu.iwha.insurancelandingpage.api

import eu.iwha.insurancelandingpage.adapter.UserNotFoundException
import eu.iwha.insurancelandingpage.domain.User
import eu.iwha.insurancelandingpage.domain.UserId
import eu.iwha.insurancelandingpage.domain.UserRepository
import mu.KotlinLogging
import org.springframework.context.event.ContextStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleUserNotFound(exception: UserNotFoundException) {
        logger.warn { exception.message }
    }
}