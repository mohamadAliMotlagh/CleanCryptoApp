package com.app.exzi.trade.data.model.market

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Main(
    @SerializedName("cap")
    val cap: Long?,
    @SerializedName("cap_f")
    val capF: String?,
    @SerializedName("circulating_supply")
    val circulatingSupply: String?,
    @SerializedName("decimal")
    val decimal: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("iso3")
    val iso3: String?,
    @SerializedName("maximum_supply")
    val maximumSupply: String?,
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
    @SerializedName("total_supply")
    val totalSupply: String?,
)
