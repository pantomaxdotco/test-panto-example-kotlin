package github.luthfipun.springrestapi.common.controller

import github.luthfipun.springrestapi.common.services.ProductService
import github.luthfipun.springrestapi.domain.entity.Product
import github.luthfipun.springrestapi.domain.model.DataState
import github.luthfipun.springrestapi.domain.model.InsertProductRequest
import github.luthfipun.springrestapi.domain.model.ProductResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/")
class ProductController(
    val productService: ProductService
) {

    @GetMapping(
        value = ["product"],
        produces = ["application/json"]
    )
    fun getProducts(): DataState<List<Product>>{
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

    @GetMapping(
        value = ["product/{id}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id") id: Long): DataState<ProductResponse> {
        return productService.getProduct(id = id)
    }
}