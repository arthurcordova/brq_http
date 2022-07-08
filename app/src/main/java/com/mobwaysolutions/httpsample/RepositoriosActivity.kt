package com.mobwaysolutions.httpsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputLayout
import com.mobwaysolutions.httpsample.adapter.RepositorioAdapter
import com.mobwaysolutions.httpsample.dto.RepositorioModel
import com.mobwaysolutions.httpsample.service.RetrofitHelper
import com.mobwaysolutions.httpsample.view.IssuesActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriosActivity : AppCompatActivity(), Callback<List<RepositorioModel>> {

    lateinit var rvRepositorios: RecyclerView
    lateinit var etSearch: TextInputLayout
    lateinit var buttonSearch: AppCompatImageButton
    lateinit var cipLoading: CircularProgressIndicator
    private val repositorioAdapter = RepositorioAdapter { repo ->
        Intent(this, IssuesActivity::class.java).apply {
            putExtra("repo_p", repo)
            putExtra("owner_p", "arthurcordova")
            startActivity(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositorios)

        etSearch = findViewById(R.id.tilSearch)
        buttonSearch = findViewById(R.id.bSearch)
        cipLoading = findViewById(R.id.cpiLoading)
        rvRepositorios = findViewById(R.id.rvRepositorios)
        rvRepositorios.adapter = repositorioAdapter
        rvRepositorios.layoutManager = LinearLayoutManager(this)

        buttonSearch.setOnClickListener {
            etSearch.editText?.text.let {
                val query = it?.toString().orEmpty()
                if (query.isNotEmpty()) {
                    cipLoading.mostrar()
                    repositorioAdapter.refresh(emptyList())
                    fetchData(query)
                }
            }
        }

        fetchData("arthurcordova")
    }

    fun fetchData(userName: String) {
        val services = RetrofitHelper.initGithubServices()
        val call = services.repositoriosDoUsuario(userName)
        call.enqueue(this)
    }

    override fun onResponse(
        call: Call<List<RepositorioModel>>,
        response: Response<List<RepositorioModel>>
    ) {
        cipLoading.esconder()

        val listaDerepositorios = response.body()
        listaDerepositorios?.let {
            repositorioAdapter.refresh(it)
        }
    }

    override fun onFailure(call: Call<List<RepositorioModel>>, t: Throwable) {
        cipLoading.esconder()


    }
}
