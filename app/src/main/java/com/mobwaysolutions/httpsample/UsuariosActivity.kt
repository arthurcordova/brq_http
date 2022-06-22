package com.mobwaysolutions.httpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.adapter.UsuarioAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuariosActivity : AppCompatActivity() {

    lateinit var viewModel: UsuariosViewModel
    lateinit var rvUsuarios : RecyclerView
    val usuarioAdapter = UsuarioAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios)
        viewModel = ViewModelProvider(this)[UsuariosViewModel::class.java]

        setupRecyclerView()
        setupObserver()

        viewModel.fetchData()
    }

    private fun setupObserver() {
        viewModel.listaDeUsuariosLiveData.observe(this) {
            usuarioAdapter.refresh(it)
        }
    }

    fun setupRecyclerView() {
        rvUsuarios = findViewById(R.id.rvUsuarios)
        rvUsuarios.layoutManager = LinearLayoutManager(this)
        rvUsuarios.adapter = usuarioAdapter
    }

}