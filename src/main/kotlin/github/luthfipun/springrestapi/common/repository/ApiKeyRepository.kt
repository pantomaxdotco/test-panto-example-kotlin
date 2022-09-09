package github.luthfipun.springrestapi.common.repository

import github.luthfipun.springrestapi.domain.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, Long>