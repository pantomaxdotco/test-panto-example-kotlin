package github.luthfipun.springrestapi.common.repository

import github.luthfipun.springrestapi.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
    fun getAllProducts(): List<Product> {
        return findAll()
    }
}
