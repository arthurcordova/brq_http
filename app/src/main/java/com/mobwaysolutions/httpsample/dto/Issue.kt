package com.mobwaysolutions.httpsample.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Issue(
    val id: Int?,
    @SerializedName("node_id")
    val nodeId: String?,
    val number: Int?,
    val state: String?,
    val title: String?,
    val body: String?
) : Serializable
