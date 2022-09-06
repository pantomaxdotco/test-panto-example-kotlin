package github.luthfipun.springrestapi.common.controller

import github.luthfipun.springrestapi.common.services.ProductService
import github.luthfipun.springrestapi.domain.model.*
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
    fun getProducts(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "limit", defaultValue = "5") limit: Int,
    ): DataState<PagingProductResponse>{
        val pagingRequest = PagingRequest(page = page, limit = limit)
        return productService.getProducts(pagingRequest = pagingRequest)
    }

    @PostMapping(
        value = ["product"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun insertProduct(@RequestBody insertUpdateProductRequest: InsertUpdateProductRequest): DataState<Nothing> {
        return productService.insertProduct(insertUpdateProductRequest = insertUpdateProductRequest)
    }

    @GetMapping(
        value = ["product/{id}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id") id: Long): DataState<ProductResponse> {
        return productService.getProduct(id = id)
    }

    @PutMapping(
        value = ["product/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("id") id: Long,
        @RequestBody insertUpdateProductRequest: InsertUpdateProductRequest
    ): DataState<Nothing> {
        return productService.updateProduct(id = id, insertUpdateProductRequest = insertUpdateProductRequest)
    }

    @DeleteMapping(
        value = ["product/{id}"],
        produces = ["application/json"]
    )
    fun deleteProduct(
        @PathVariable("id") id: Long
    ): DataState<Nothing> {
        return productService.deleteProduct(id = id)
    }
}