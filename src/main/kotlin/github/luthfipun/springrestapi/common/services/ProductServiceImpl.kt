package github.luthfipun.springrestapi.common.services

import github.luthfipun.springrestapi.common.error.NotFoundException
import github.luthfipun.springrestapi.common.repository.ProductRepository
import github.luthfipun.springrestapi.domain.model.*
import github.luthfipun.springrestapi.domain.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {

    override fun getProducts(pagingRequest: PagingRequest): DataState<PagingProductResponse> {
        val products = productRepository.findAll(
            PageRequest.of(pagingRequest.page, pagingRequest.limit)
        )
        val pagingData = PagingProductResponse(
            total = products.totalPages,
            current_page = products.number,
            prev_page = if(products.hasPrevious()) products.previousPageable().pageNumber else null,
            content = products.get().collect(Collectors.toList())?.map { it.toProductResponse() } ?: listOf()
        )
        return DataState(data = pagingData)
    }

    override fun insertProduct(insertUpdateProductRequest: InsertUpdateProductRequest): DataState<Nothing> {
        validationUtil.validate(insertUpdateProductRequest)
        productRepository.save(insertUpdateProductRequest.toProduct())
        return DataState(data = null)
    }

    override fun getProduct(id: Long): DataState<ProductResponse> {
        val product = productRepository.findById(id)
        if (product.isEmpty){
            throw NotFoundException()
        }
        return DataState(data = product.get().toProductResponse())
    }

    override fun updateProduct(id: Long, insertUpdateProductRequest: InsertUpdateProductRequest): DataState<Nothing> {
        val product = productRepository.findById(id)
        if (product.isEmpty){
            throw NotFoundException()
        }
        validationUtil.validate(insertUpdateProductRequest)
        product.map {
            it.name = insertUpdateProductRequest.name
            it.price = insertUpdateProductRequest.price
            it.qty = insertUpdateProductRequest.qty
            it.updatedAt = Date()
        }
        productRepository.save(product.get())
        return DataState(data = null)
    }

    override fun deleteProduct(id: Long): DataState<Nothing> {
        val product = productRepository.existsById(id)
        if (!product){
            throw NotFoundException()
        }
        productRepository.deleteById(id)
        return DataState(data = null)
    }
}