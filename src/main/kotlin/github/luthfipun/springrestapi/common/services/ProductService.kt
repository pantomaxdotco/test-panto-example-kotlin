package github.luthfipun.springrestapi.common.services

import github.luthfipun.springrestapi.domain.entity.Product
import github.luthfipun.springrestapi.domain.model.DataState
import github.luthfipun.springrestapi.domain.model.InsertProductRequest

interface ProductService {
    fun getProducts(): DataState<List<Product>>
    fun insertProduct(insertProductRequest: InsertProductRequest): DataState<Nothing>
}