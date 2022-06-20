package com.mobwaysolutions.httpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriosActivity : AppCompatActivity(), Callback<List<RepositorioModel>> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositorios)

        val services = RetrofitHelper.initGithubServices()
        val call = services.repositoriosDoUsuario("arthurcordova")
        call.enqueue(this)
    }

    override fun onResponse(
        call: Call<List<RepositorioModel>>,
        response: Response<List<RepositorioModel>>
    ) {
        println("")
    }

    override fun onFailure(call: Call<List<RepositorioModel>>, t: Throwable) {
        println("")
    }
}