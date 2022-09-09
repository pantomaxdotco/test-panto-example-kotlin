package github.luthfipun.springrestapi.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "api_key")
data class ApiKey(
    @Id
    val id: Long,

    @Column(name = "api_key")
    val apiKey: String
)
