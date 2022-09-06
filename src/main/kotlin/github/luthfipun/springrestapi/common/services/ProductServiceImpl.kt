package github.luthfipun.springrestapi.common.services

import github.luthfipun.springrestapi.common.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository
) : ProductService {
    override fun test(): String {
        return "hello world"
    }
}