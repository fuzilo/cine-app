package com.fatec.cineapp.core.feature.movie.popular.data.source

import MovieResponse
import com.fatec.cineapp.core.data.remote.MovieService
import com.fatec.cineapp.core.feature.movie.popular.domain.source.MoviePopularRemoteDataSource
import com.fatec.cineapp.core.paging.MoviePagingSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
): MoviePopularRemoteDataSource {

    override fun getPopularMoviesPagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page)
    }
}