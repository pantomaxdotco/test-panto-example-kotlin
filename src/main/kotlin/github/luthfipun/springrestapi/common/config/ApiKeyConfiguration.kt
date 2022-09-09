package github.luthfipun.springrestapi.common.config

import github.luthfipun.springrestapi.common.interceptor.ApiKeyInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class ApiKeyConfiguration(
    val apiKeyInterceptor: ApiKeyInterceptor
): WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)
        registry.addWebRequestInterceptor(apiKeyInterceptor)
    }
}