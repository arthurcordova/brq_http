package com.mobwaysolutions.httpsample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mobwaysolutions.httpsample.R
import com.mobwaysolutions.httpsample.service.RetrofitHelper
import com.mobwaysolutions.httpsample.dto.Issue
import com.mobwaysolutions.httpsample.dto.IssueCommentRequest
import com.mobwaysolutions.httpsample.dto.RepositorioModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IssuesActivity : AppCompatActivity(), Callback<List<Issue>> {

    private var issue: Issue? = null
    private val services = RetrofitHelper.initGithubServices()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issues)

        val repo = intent.getSerializableExtra("repo_p") as? RepositorioModel
        val owner = intent.getStringExtra("owner_p")

        findViewById<TextView>(R.id.tvTitle).apply {
            text = repo?.nomeCompleto
        }

        fetchData(owner!!, repo!!.nome)

        findViewById<Button>(R.id.btSend).setOnClickListener {

            val etComment = findViewById<TextView>(R.id.etComment)

            val call = services.addComment(
                owner,
                repo.nome,
                issue!!.number.toString(),
                IssueCommentRequest(etComment.text.toString())
            )
            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    println()
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }



            })


        }
    }

    fun fetchData(owner: String, repoName: String) {
        val call = services.getIssues(owner, repoName)
        call.enqueue(this)
    }

    override fun onResponse(call: Call<List<Issue>>, response: Response<List<Issue>>) {
        response.body()?.let {
            issue = it.first()

            findViewById<TextView>(R.id.tvTitleIssue).apply {
                text = issue?.title
            }
            findViewById<TextView>(R.id.tvBodyIssue).apply {
                text = issue?.body
            }


        }
    }

    override fun onFailure(call: Call<List<Issue>>, t: Throwable) {
        println("")
    }
}