package com.mobwaysolutions.httpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.mobwaysolutions.httpsample.adapter.UsuarioAdapter
import com.mobwaysolutions.httpsample.interact.UsuariosInteract

class UsuariosActivity : AppCompatActivity() {

    lateinit var viewModel: UsuariosViewModel
    lateinit var rvUsuarios : RecyclerView
    lateinit var cpiLoading : CircularProgressIndicator
    val usuarioAdapter = UsuarioAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios)
        viewModel = ViewModelProvider(this)[UsuariosViewModel::class.java]

        setupComponents()
        setupObserver()

        viewModel.fetchData()
    }

    private fun setupObserver() {
        viewModel.listaDeUsuariosLiveData.observe(this) {
            usuarioAdapter.refresh(it)
        }

        viewModel.eventoInteract.observe(this) { interact ->
            when(interact) {
                is UsuariosInteract.Loading -> cpiLoading.mostrar()
                is UsuariosInteract.OnFinish -> cpiLoading.esconder()
            }
        }
    }

    fun setupComponents() {
        cpiLoading = findViewById(R.id.cpiLoading)
        rvUsuarios = findViewById(R.id.rvUsuarios)
        rvUsuarios.layoutManager = LinearLayoutManager(this)
        rvUsuarios.adapter = usuarioAdapter
    }

}