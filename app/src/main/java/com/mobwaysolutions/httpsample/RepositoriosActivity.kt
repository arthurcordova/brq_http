package com.mobwaysolutions.httpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.adapter.RepositorioAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriosActivity : AppCompatActivity(), Callback<List<RepositorioModel>> {

    lateinit var rvRepositorios: RecyclerView
    private val repositorioAdapter = RepositorioAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositorios)

        rvRepositorios = findViewById(R.id.rvRepositorios)
        rvRepositorios.adapter = repositorioAdapter
        rvRepositorios.layoutManager = LinearLayoutManager(this)

        val services = RetrofitHelper.initGithubServices()
        val call = services.repositoriosDoUsuario("arthurcordova")
        call.enqueue(this)
    }

    override fun onResponse(
        call: Call<List<RepositorioModel>>,
        response: Response<List<RepositorioModel>>
    ) {
        val listaDerepositorios = response.body()
        listaDerepositorios?.let {
            repositorioAdapter.refresh(it)
        }
    }

    override fun onFailure(call: Call<List<RepositorioModel>>, t: Throwable) {
    }
}