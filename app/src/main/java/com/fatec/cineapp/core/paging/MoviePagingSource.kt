package com.fatec.cineapp.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fatec.cineapp.core.domain.model.Movie
import com.fatec.cineapp.core.feature.movie.popular.data.mapper.toMovie
import com.fatec.cineapp.core.feature.movie.popular.domain.source.MoviePopularRemoteDataSource
import retrofit2.HttpException
import java.io.IOException


/**
 * Uma fonte de paginação para carregar filmes populares de uma fonte de dados remota.
 *
 * Esta classe estende `PagingSource` e é responsável por buscar e fornecer dados de filmes paginados
 * para um `MoviePopularRemoteDataSource` em seu aplicativo Android. Ela usa a biblioteca Paging 3 para carregar
 * e exibir listas grandes de filmes de forma eficiente.
 *
 * @param remoteDataSource A fonte de dados remota para buscar os filmes.
 */
class MoviePagingSource(
    private val remoteDataSource: MoviePopularRemoteDataSource
) :
    PagingSource<Int, Movie>() {
    /**
     * Obtém a chave de atualização para a posição de âncora atual.
     *
     * Esta função é chamada pela biblioteca Paging quando uma atualização é acionada (por exemplo,
     * por um gesto de deslizar para atualizar). Ela ajuda a biblioteca a determinar onde retomar
     * o carregamento de dados após a atualização.
     *
     * @param state O estado atual das páginas carregadas.
     * @return A chave de atualização para a posição de âncora atual, ou nulo se não houver
     * posição de âncora.
     */
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    /**
     * Carrega uma página de dados de filmes.
     *
     * Esta função é chamada pela biblioteca Paging para carregar uma página de dados. Ela busca
     * os dados da fonte de dados remota e retorna um `LoadResult` que contém os dados,
     * bem como as chaves para as páginas anterior e próxima.
     *
     * @param params Os parâmetros da solicitação de carregamento.
     * @return Um `LoadResult` que contém os dados da página, ou um erro se a solicitação falhar.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getPopularMovies(pageNumber)
            val movies = response.results

            LoadResult.Page(
                data = movies.toMovie(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (movies.isEmpty()) null else pageNumber + 1
            )

        } catch (exception: IOException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val LIMIT = 20
    }
}