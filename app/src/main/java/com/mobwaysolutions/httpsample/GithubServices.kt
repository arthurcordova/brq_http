package com.mobwaysolutions.httpsample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubServices {

    @GET("users/{user}/repos")
    fun repositoriosDoUsuario(@Path("user") user : String) : Call<List<RepositorioModel>>

}