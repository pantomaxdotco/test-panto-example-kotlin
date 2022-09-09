package github.luthfipun.springrestapi.common.controller

import github.luthfipun.springrestapi.common.error.NotFoundException
import github.luthfipun.springrestapi.common.error.UnAuthorizeException
import github.luthfipun.springrestapi.domain.model.DataState
import org.springframework.http.HttpStatus
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
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
    fun notFoundHandler(notFoundException: NotFoundException): DataState<Nothing> {
        return DataState(
            status = false,
            code = HttpStatus.NOT_FOUND.value(),
            message = HttpStatus.NOT_FOUND.reasonPhrase,
            data = null
        )
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [NoHandlerFoundException::class])
    fun notFound(notFound: NoHandlerFoundException): DataState<Nothing> {
        return DataState(
            status = false,
            code = HttpStatus.NOT_FOUND.value(),
            message = notFound.message.orEmpty(),
            data = null
        )
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = [HttpRequestMethodNotSupportedException::class])
    fun methodNotAllowed(httpRequestMethodNotSupportedException: HttpRequestMethodNotSupportedException): DataState<Nothing> {
        return DataState(
            status = false,
            code = HttpStatus.METHOD_NOT_ALLOWED.value(),
            message = httpRequestMethodNotSupportedException.message.orEmpty(),
            data = null
        )
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = [UnAuthorizeException::class])
    fun unAuthorizeHandler(unAuthorizeException: UnAuthorizeException): DataState<Nothing> {
        return DataState(
            status = false,
            code = HttpStatus.UNAUTHORIZED.value(),
            message = HttpStatus.UNAUTHORIZED.reasonPhrase,
            data = null
        )
    }
}