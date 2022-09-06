package github.luthfipun.springrestapi.domain.model

import github.luthfipun.springrestapi.domain.entity.Product
import java.util.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class InsertUpdateProductRequest(
    @field:NotBlank
    val name: String,

    @field:Min(value = 0)
    val price: Long,

    @field:Min(value = 1)
    val qty: Int
){
    fun toProduct(): Product {
        return Product(
            name = this.name,
            price = this.price,
            qty = this.qty,
            createdAt = Date(),
            updatedAt = null
        )
    }
}
