package com.app.exzi.trade.data.model.market


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Data(
    @SerializedName("ath")
    val ath: Int?,
    @SerializedName("ath_f")
    val athF: String?,
    @SerializedName("atl")
    val atl: Int?,
    @SerializedName("atl_f")
    val atlF: String?,
    @SerializedName("close")
    val close: Int?,
    @SerializedName("close_f")
    val closeF: String?,
    @SerializedName("commission_min")
    val commissionMin: Any?,
    @SerializedName("commission_percent")
    val commissionPercent: Double?,
    @SerializedName("commission_percent_market")
    val commissionPercentMarket: String?,
    @SerializedName("filters")
    val filters: List<String?>?,
    @SerializedName("fixed")
    val fixed: Any?,
    @SerializedName("high")
    val high: Long?,
    @SerializedName("high_f")
    val highF: String?,
    @SerializedName("_id")
    val _id: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("last_rate24")
    val lastRate24: Long?,
    @SerializedName("last_rate24_f")
    val lastRate24F: String?,
    @SerializedName("last_rateH")
    val lastRateH: Long?,
    @SerializedName("last_rateH_f")
    val lastRateHF: String?,
    @SerializedName("last_rateW")
    val lastRateW: Long?,
    @SerializedName("last_rateW_f")
    val lastRateWF: String?,
    @SerializedName("logo")
    val logo: Any?,
    @SerializedName("low")
    val low: Long?,
    @SerializedName("low_f")
    val lowF: String?,
    @SerializedName("main")
    val main: Main?,
    @SerializedName("main_currency_id")
    val mainCurrencyId: Int?,
    @SerializedName("margin_leverage")
    val marginLeverage: Int?,
    @SerializedName("min_amount")
    val minAmount: Double?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("open")
    val `open`: Int?,
    @SerializedName("open_f")
    val openF: String?,
    @SerializedName("pair_type")
    val pairType: Any?,
    @SerializedName("percent")
    val percent: Float?,
    @SerializedName("percentH")
    val percentH: Double?,
    @SerializedName("percentW")
    val percentW: Double?,
    @SerializedName("rate")
    val rate: Long?,
    @SerializedName("rate_f")
    val rateF: String?,
    @SerializedName("second")
    val second: Second?,
    @SerializedName("second_currency_id")
    val secondCurrencyId: Int?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("time_create")
    val timeCreate: Int?,
    @SerializedName("time_update")
    val timeUpdate: Int?,
    @SerializedName("type")
    val type: Int?,
    @SerializedName("type_update_time")
    val typeUpdateTime: Any?,
    @SerializedName("volume")
    val volume: Double?,
    @SerializedName("volume_f")
    val volumeF: String?,
    @SerializedName("volume_second_world")
    val volumeSecondWorld: String?,
    @SerializedName("volume_second_world_f")
    val volumeSecondWorldF: String?,
    @SerializedName("volume_world")
    val volumeWorld: String?,
    @SerializedName("volume_world_f")
    val volumeWorldF: String?,
    @SerializedName("volumes")
    val volumes: Volumes?
)