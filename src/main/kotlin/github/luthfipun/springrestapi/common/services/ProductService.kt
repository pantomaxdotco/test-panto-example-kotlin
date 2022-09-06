package github.luthfipun.springrestapi.common.services

import github.luthfipun.springrestapi.domain.entity.Product
import github.luthfipun.springrestapi.domain.model.DataState
import github.luthfipun.springrestapi.domain.model.InsertProductRequest
import github.luthfipun.springrestapi.domain.model.ProductResponse

interface ProductService {
    fun getProducts(): DataState<List<Product>>
    fun insertProduct(insertProductRequest: InsertProductRequest): DataState<Nothing>
    fun getProduct(id: Long): DataState<ProductResponse>
}