package com.mobwaysolutions.httpsample

import com.mobwaysolutions.httpsample.dto.Issue
import com.mobwaysolutions.httpsample.dto.IssueCommentRequest
import com.mobwaysolutions.httpsample.dto.RepositorioModel
import com.mobwaysolutions.httpsample.dto.UsuarioModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface GithubServices {

    @GET("users/{user}/repos")
    fun repositoriosDoUsuario(@Path("user") user: String): Call<List<RepositorioModel>>

    @GET("users")
    fun usuarios(): Call<List<UsuarioModel>>

    @GET("/repos/{owner}/{repo}/issues")
    fun getIssues(@Path("owner") owner: String, @Path("repo") repo: String): Call<List<Issue>>

    @POST("/repos/{owner}/{repo}/issues/{issue_number}/comments")
    fun addComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") number: String,
        @Body body : IssueCommentRequest
    ) : Call<ResponseBody>

}