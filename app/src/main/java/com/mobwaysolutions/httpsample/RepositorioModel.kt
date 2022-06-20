package com.mobwaysolutions.httpsample

import com.google.gson.annotations.SerializedName

data class RepositorioModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val nome: String,
    @SerializedName("full_name")
    val nomeCompleto : String
)
