package com.fatec.cineapp.core.domain.model

data class MovieDetails(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val overview: String?,
    val backdropUrl: String?,
    val releaseDate: String?,
    val voteAverage: Double,
    val duration: Int = 0,
    val voteCount: Int = 0
)
