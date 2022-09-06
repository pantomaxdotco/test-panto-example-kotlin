package github.luthfipun.springrestapi.domain.model

data class PagingProductResponse(
    val total: Int,
    val current_page: Int,
    val prev_page: Int?,
    val content: List<ProductResponse>
)