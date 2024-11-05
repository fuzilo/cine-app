package com.fatec.cineapp.core.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    fun getPopuarMovies(){

    //    @Query("page") page: Int,
      //  @Path("page") pageParam:
       // ): MovieResponse;

        }
    }
