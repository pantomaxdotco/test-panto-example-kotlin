package github.luthfipun.springrestapi.common.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppProperties {
    @Value("\${app.secret.key}")
    lateinit var secretKey: String
}