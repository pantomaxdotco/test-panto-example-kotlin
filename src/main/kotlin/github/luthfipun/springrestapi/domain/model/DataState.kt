package github.luthfipun.springrestapi.domain.model

data class DataState<T>(
    val status: Boolean = true,
    val code: Int = 200,
    val message: String = "Ok",
    val data: T?
)