package com.fatec.cineapp.core.util

/**
 * Uma classe selada que representa o resultado de uma operação que pode ser carregando, sucesso ou falha.
 *
 * @param <T> O tipo de dado retornado após a conclusão bem-sucedida da operação.
 */
sealed class ResultData<out T> {
    /**
     * Representa o estado em que a operação está em andamento.
     */
    object Loading : ResultData<Nothing>()
    /**
     * Representa a conclusão bem-sucedida da operação com os dados retornados.
     *
     * @param data Os dados retornados pela operação, que podem ser nulos.
     */
    data class Success<out T>(val data: T?) : ResultData<T>()
    /**
     * Representa a falha da operação com uma exceção opcional.
     *
     * @param exception A exceção que ocorreu durante a operação, que pode ser nula.
     */
    data class Failure(val exception: Exception?) : ResultData<Nothing>()
}
