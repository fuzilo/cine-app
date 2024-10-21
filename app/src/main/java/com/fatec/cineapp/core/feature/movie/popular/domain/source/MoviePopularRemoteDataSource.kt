package com.fatec.cineapp.core.feature.movie.popular.domain.source

import MovieResponse
import com.fatec.cineapp.core.paging.MoviePagingSource

interface MoviePopularRemoteDataSource {
    fun getPopularMoviesPagingSource(): MoviePagingSource

    suspend fun getPopularMovies(page: Int): MovieResponse
}