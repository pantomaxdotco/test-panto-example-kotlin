package github.luthfipun.springrestapi.common.controller

import github.luthfipun.springrestapi.common.services.ProductService
import github.luthfipun.springrestapi.domain.entity.Product
import github.luthfipun.springrestapi.domain.model.DataState
import github.luthfipun.springrestapi.domain.model.InsertProductRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class ProductController(
    val productService: ProductService
) {

    @GetMapping(
        value = ["product"],
        produces = ["application/json"]
    )
    fun getProduct(): DataState<List<Product>>{
        return productService.getProducts()
    }

    @PostMapping(
        value = ["product"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun insertProduct(@RequestBody insertProductRequest: InsertProductRequest): DataState<Nothing> {
        return productService.insertProduct(insertProductRequest = insertProductRequest)
    }
}