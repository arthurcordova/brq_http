package com.mobwaysolutions.httpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.adapter.UsuarioAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuariosActivity : AppCompatActivity(), Callback<List<UsuarioModel>> {

    lateinit var rvUsuarios : RecyclerView
    val usuarioAdapter = UsuarioAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios)

        rvUsuarios = findViewById(R.id.rvUsuarios)
        rvUsuarios.layoutManager = LinearLayoutManager(this)
        rvUsuarios.adapter = usuarioAdapter

        fetchData()
    }

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
            usuarioAdapter.refresh(it)
        }
    }

    override fun onFailure(call: Call<List<UsuarioModel>>, t: Throwable) {
        println("")
    }
}