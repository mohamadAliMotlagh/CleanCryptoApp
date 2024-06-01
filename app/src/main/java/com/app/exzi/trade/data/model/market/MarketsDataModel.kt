package com.app.exzi.trade.data.model.market

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MarketsDataModel(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("is_login")
    val isLogin: Boolean?,
    @SerializedName("status")
    val status: Boolean?,
)
