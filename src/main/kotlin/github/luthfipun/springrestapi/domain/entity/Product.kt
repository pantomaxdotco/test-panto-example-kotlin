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
    var name: String,

    @Column(name = "price")
    var price: Long,

    @Column(name = "qty")
    var qty: Int,

    @Column(name = "created_at")
    val createdAt: Date,

    @Column(name = "updated_at")
    var updatedAt: Date?,

    @Column(name = "deleted_at_timestamp_for_soft_deletion")
    var deletedAtTimestampForSoftDeletion: Date? = null
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
