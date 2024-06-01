package com.app.exzi.trade.data.model.market

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Volumes(
    @SerializedName("d")
    val d: Double?,
    @SerializedName("m")
    val m: Double?,
    @SerializedName("w")
    val w: Double?,
)
