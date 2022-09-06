package github.luthfipun.springrestapi.common.controller

import github.luthfipun.springrestapi.common.error.NotFoundException
import github.luthfipun.springrestapi.domain.model.DataState
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): DataState<Nothing> {
        return DataState(
            status = false,
            code = HttpStatus.NOT_ACCEPTABLE.value(),
            message = constraintViolationException.message.orEmpty(),
            data = null
        )
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): DataState<Nothing> {
        return DataState(
            status = false,
            code = HttpStatus.NOT_FOUND.value(),
            message = HttpStatus.NOT_FOUND.reasonPhrase,
            data = null
        )
    }
}