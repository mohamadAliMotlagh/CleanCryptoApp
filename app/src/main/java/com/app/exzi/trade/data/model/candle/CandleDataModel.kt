package com.app.exzi.trade.data.model.candle

import com.google.gson.annotations.SerializedName

data class CandleDataModel(
    @SerializedName("close")
    val close: Long?,
    @SerializedName("close_f")
    val closeF: String?,
    @SerializedName("high")
    val high: Long?,
    @SerializedName("high_f")
    val highF: String?,
    @SerializedName("low")
    val low: Long?,
    @SerializedName("low_f")
    val lowF: String?,
    @SerializedName("open")
    val `open`: Long?,
    @SerializedName("open_f")
    val openF: String?,
    @SerializedName("pair")
    val pair: String?,
    @SerializedName("pair_id")
    val pairId: Int?,
    @SerializedName("time")
    val time: Long?,
    @SerializedName("volume")
    val volume: Long?,
    @SerializedName("volume_f")
    val volumeF: String?,
)
