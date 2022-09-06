package github.luthfipun.springrestapi.common.services

import github.luthfipun.springrestapi.domain.model.*

interface ProductService {
    fun getProducts(pagingRequest: PagingRequest): DataState<PagingProductResponse>
    fun insertProduct(insertUpdateProductRequest: InsertUpdateProductRequest): DataState<Nothing>
    fun getProduct(id: Long): DataState<ProductResponse>
    fun updateProduct(id: Long, insertUpdateProductRequest: InsertUpdateProductRequest): DataState<Nothing>
    fun deleteProduct(id: Long): DataState<Nothing>
}