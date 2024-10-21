package com.fatec.cineapp.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
)
