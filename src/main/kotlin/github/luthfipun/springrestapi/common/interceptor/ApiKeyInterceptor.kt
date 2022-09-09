package github.luthfipun.springrestapi.common.interceptor

import github.luthfipun.springrestapi.common.error.UnAuthorizeException
import github.luthfipun.springrestapi.common.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor

@Component
class ApiKeyInterceptor(
    val apiKeyRepository: ApiKeyRepository
): WebRequestInterceptor {

    override fun preHandle(request: WebRequest) {
        val auth = request.getHeader("X-Auth-API")
        auth?.let { authValue ->

            val apiKey = apiKeyRepository.findById(1)
            if (authValue != apiKey.get().apiKey){
                throw UnAuthorizeException()
            }

        } ?: throw UnAuthorizeException()
    }

    override fun postHandle(request: WebRequest, model: ModelMap?){}

    override fun afterCompletion(request: WebRequest, ex: Exception?){}
}