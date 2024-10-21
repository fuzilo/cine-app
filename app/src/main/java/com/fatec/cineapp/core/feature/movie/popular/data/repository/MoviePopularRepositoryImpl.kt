package com.fatec.cineapp.core.feature.movie.popular.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fatec.cineapp.core.domain.model.Movie
import com.fatec.cineapp.core.feature.movie.popular.domain.repository.MoviePopularRepository
import com.fatec.cineapp.core.feature.movie.popular.domain.source.MoviePopularRemoteDataSource
import kotlinx.coroutines.flow.Flow

class MoviePopularRepositoryImpl constructor(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : MoviePopularRepository {

    override fun getPopularMovies(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getPopularMoviesPagingSource()
            }

        ).flow
    }
}