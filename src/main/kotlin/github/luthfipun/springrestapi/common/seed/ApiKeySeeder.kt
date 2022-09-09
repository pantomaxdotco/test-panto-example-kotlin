package github.luthfipun.springrestapi.common.seed

import github.luthfipun.springrestapi.common.repository.ApiKeyRepository
import github.luthfipun.springrestapi.common.util.AppProperties
import github.luthfipun.springrestapi.common.util.Md5Encode
import github.luthfipun.springrestapi.domain.entity.ApiKey
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeeder(
    val apiKeyRepository: ApiKeyRepository,
    val md5Encoder: Md5Encode,
    val appProperties: AppProperties
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        // Create dummy apikey when app started,
        // you can change this with your api secret key
        if (!apiKeyRepository.existsById(1)){
            val apiKey = ApiKey(
                id = 1,
                apiKey = md5Encoder.encode(value = appProperties.secretKey)
            )
            apiKeyRepository.save(apiKey)
        }
    }
}