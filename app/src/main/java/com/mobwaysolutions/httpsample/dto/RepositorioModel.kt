package com.mobwaysolutions.httpsample.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepositorioModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val nome: String,
    @SerializedName("full_name")
    val nomeCompleto : String
) : Serializable
