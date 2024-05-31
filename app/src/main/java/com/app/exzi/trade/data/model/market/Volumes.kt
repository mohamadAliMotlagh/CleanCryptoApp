package com.app.exzi.trade.data.model.market


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Volumes(
    @SerializedName("d")
    val d: Double?,
    @SerializedName("m")
    val m: Double?,
    @SerializedName("w")
    val w: Double?
)