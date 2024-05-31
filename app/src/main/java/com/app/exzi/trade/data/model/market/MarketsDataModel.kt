package com.app.exzi.trade.data.model.market


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class MarketsDataModel(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("is_login")
    val isLogin: Boolean?,
    @SerializedName("status")
    val status: Boolean?
)