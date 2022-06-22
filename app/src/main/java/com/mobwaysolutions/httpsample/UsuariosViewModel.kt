package com.mobwaysolutions.httpsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobwaysolutions.httpsample.interact.UsuariosInteract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuariosViewModel : ViewModel(), Callback<List<UsuarioModel>> {

    val listaDeUsuariosLiveData = MutableLiveData<List<UsuarioModel>>()

    val eventoInteract = MutableLiveData<UsuariosInteract>()

    fun fetchData() {
        eventoInteract.value = UsuariosInteract.Loading
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
        eventoInteract.value = UsuariosInteract.OnFinish
    }

    override fun onFailure(call: Call<List<UsuarioModel>>, t: Throwable) {
        eventoInteract.value = UsuariosInteract.OnFinish
    }

}