package net.timlin.apiclienttest.data

data class SearchResponse(
    val results: List<SearchItem>,
    val total: Int
)

data class SearchItem(
    val id: Int,
    val name: String
)
