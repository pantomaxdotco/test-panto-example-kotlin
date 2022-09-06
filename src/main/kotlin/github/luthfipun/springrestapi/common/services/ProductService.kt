package github.luthfipun.springrestapi.common.services

import github.luthfipun.springrestapi.domain.entity.Product
import github.luthfipun.springrestapi.domain.model.DataState
import github.luthfipun.springrestapi.domain.model.InsertUpdateProductRequest
import github.luthfipun.springrestapi.domain.model.ProductResponse

interface ProductService {
    fun getProducts(): DataState<List<Product>>
    fun insertProduct(insertUpdateProductRequest: InsertUpdateProductRequest): DataState<Nothing>
    fun getProduct(id: Long): DataState<ProductResponse>
    fun updateProduct(id: Long, insertUpdateProductRequest: InsertUpdateProductRequest): DataState<Nothing>
    fun deleteProduct(id: Long): DataState<Nothing>
}