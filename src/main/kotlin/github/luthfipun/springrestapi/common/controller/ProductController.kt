package github.luthfipun.springrestapi.common.controller

import github.luthfipun.springrestapi.common.services.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    val productService: ProductService
) {

    @GetMapping(
        value = ["/hello"],
        produces = ["application/json"]
    )
    fun test(): String{
        return productService.test()
    }
}