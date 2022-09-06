package github.luthfipun.springrestapi.domain.model

import java.util.Date

data class ProductResponse(
    val id: Long,
    val name: String,
    val price: Long,
    val qty: Int,
    val createdAt: Date,
    val updatedAt: Date?
)