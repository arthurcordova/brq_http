package com.mobwaysolutions.httpsample.dto

import com.google.gson.annotations.SerializedName

data class UsuarioModel(
    @SerializedName("login")
    val nome: String?,
    @SerializedName("avatar_url")
    val photo: String?
)
