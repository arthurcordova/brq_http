package com.mobwaysolutions.httpsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuariosViewModel : ViewModel(), Callback<List<UsuarioModel>> {

    val listaDeUsuariosLiveData = MutableLiveData<List<UsuarioModel>>()

    fun fetchData() {
        val services = RetrofitHelper.initGithubServices()
        val call = services.usuarios()
        call.enqueue(this)
    }

    override fun onResponse(
        call: Call<List<UsuarioModel>>,
        response: Response<List<UsuarioModel>>
    ) {
        response.body()?.let {
            listaDeUsuariosLiveData.value = it
        }
    }

    override fun onFailure(call: Call<List<UsuarioModel>>, t: Throwable) {
        println("")
    }

}