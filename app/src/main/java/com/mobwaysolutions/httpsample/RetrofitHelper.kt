package com.mobwaysolutions.httpsample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    fun initGithubServices(): GithubServices {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GithubServices::class.java)
    }

}