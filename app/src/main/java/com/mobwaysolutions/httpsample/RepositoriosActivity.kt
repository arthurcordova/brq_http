package com.mobwaysolutions.httpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputLayout
import com.mobwaysolutions.httpsample.adapter.RepositorioAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriosActivity : AppCompatActivity(), Callback<List<RepositorioModel>> {

    lateinit var rvRepositorios: RecyclerView
    lateinit var etSearch: TextInputLayout
    lateinit var buttonSearch: AppCompatImageButton
    lateinit var cipLoading: CircularProgressIndicator
    private val repositorioAdapter = RepositorioAdapter()

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
