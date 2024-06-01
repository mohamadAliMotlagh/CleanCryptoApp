package com.app.exzi.trade.data.model.market

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Second(
    @SerializedName("decimal")
    val decimal: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("iso3")
    val iso3: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rate_btc")
    val rateBtc: Int?,
    @SerializedName("rate_eth")
    val rateEth: Int?,
    @SerializedName("rate_usd")
    val rateUsd: Long?,
    @SerializedName("rate_usdt")
    val rateUsdt: Long?,
)
