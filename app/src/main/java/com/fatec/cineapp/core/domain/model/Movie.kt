package com.fatec.cineapp.core.domain.model

// Classe para representar os dados mostrados de um filme
data class Movie(
    val id: Int,
    val title: String,
    val voteAverage: Double = 0.0,
    val imageUrl: String="",
)