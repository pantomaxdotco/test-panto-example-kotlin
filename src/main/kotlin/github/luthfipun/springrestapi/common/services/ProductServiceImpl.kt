package github.luthfipun.springrestapi.common.services

import github.luthfipun.springrestapi.common.repository.ProductRepository
import github.luthfipun.springrestapi.domain.entity.Product
import github.luthfipun.springrestapi.domain.model.DataState
import github.luthfipun.springrestapi.domain.model.InsertProductRequest
import github.luthfipun.springrestapi.domain.validation.ValidationUtil
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {
    override fun getProducts(): DataState<List<Product>> {
        return DataState(data = productRepository.findAll())
    }

    override fun insertProduct(insertProductRequest: InsertProductRequest): DataState<Nothing> {
        validationUtil.validate(insertProductRequest)
        productRepository.save(insertProductRequest.toProduct())
        return DataState(data = null)
    }
}