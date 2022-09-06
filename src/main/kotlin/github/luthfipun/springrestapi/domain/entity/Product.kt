package github.luthfipun.springrestapi.domain.entity

import github.luthfipun.springrestapi.domain.model.ProductResponse
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Long,

    @Column(name = "qty")
    val qty: Int,

    @Column(name = "created_at")
    val createdAt: Date,

    @Column(name = "updated_at")
    val updatedAt: Date?
){
    fun toProductResponse(): ProductResponse {
        return ProductResponse(
            id = this.id,
            name = this.name,
            price = this.price,
            qty = this.qty,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
}
