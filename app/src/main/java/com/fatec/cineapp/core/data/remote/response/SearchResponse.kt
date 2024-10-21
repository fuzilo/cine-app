package com.fatec.cineapp.core.data.remote.response

import com.fatec.cineapp.core.data.remote.model.SearchResult
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("page")
    val page: Long,
    @SerializedName("results")
    val results: List<SearchResult>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long,
)
