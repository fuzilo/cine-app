package com.fatec.cineapp.core.data.remote

import com.fatec.cineapp.BuildConfig
import com.fatec.cineapp.core.util.Constants
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Um interceptador OkHttp que adiciona parâmetros de consulta comuns às solicitações de saída.
 *
 * Este interceptador adiciona automaticamente os seguintes parâmetros de consulta à URL de cada solicitação:
 * - `language`: A preferência de idioma para a API (por exemplo, "pt-BR").
 * - `apiKey`: A chave da API para autenticação.
 *
 * Esses parâmetros são definidos na classe `Constants`.
 */
class ParamsInterceptor:Interceptor {
    /**
     * Intercepta uma solicitação de saída e adiciona os parâmetros de consulta comuns.
     *
     * @param chain A cadeia de interceptadores OkHttp.
     * @return A resposta modificada.
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        //chain recebe a requisicao original e adiciona os parametros
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(Constants.LANGUAGE_PARAM, Constants.LANGUAGE_VALUE)
            .addQueryParameter(Constants.API_KEY_PARAM, BuildConfig.API_KEY)
            .build()
        val newRequest = request.newBuilder()
            .url(url).
            build()

        return chain.proceed(newRequest)
    }
}