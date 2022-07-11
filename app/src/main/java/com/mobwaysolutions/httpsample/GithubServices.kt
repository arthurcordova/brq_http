package com.mobwaysolutions.httpsample

import com.mobwaysolutions.httpsample.dto.*
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

    @GET("/repos/{owner}/{repo}/issues/{issue_number}/comments")
    fun getIssuesComments(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issue: String
    ): Call<List<Comment>>

    @POST("/repos/{owner}/{repo}/issues/{issue_number}/comments")
    fun addComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") number: String,
        @Body body: IssueCommentRequest
    ): Call<ResponseBody>

}