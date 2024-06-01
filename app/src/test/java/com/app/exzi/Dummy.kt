package com.app.exzi

import com.app.exzi.trade.data.model.MarketOrdersDataModel
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.domain.model.MarketOrdersDomainModel
import com.google.gson.Gson

object Dummy {
    val domainOrderBook: MarketOrdersDomainModel
        get() {
            val avg = (0..100).sum() / 101
            return MarketOrdersDomainModel(
                bid =
                    (0..100).map {
                        MarketOrderDomainModel(
                            price = (it * 2000).toString(),
                            fraction = (it / avg) * 0.5f,
                            quantity = it.toString(),
                        )
                    },
                ask =
                    (0..100).map {
                        MarketOrderDomainModel(
                            price = (it * 2000).toString(),
                            fraction = (it / avg) * 0.5f,
                            quantity = it.toString(),
                        )
                    },
            )
        }
    val orderBooksRAW: MarketOrdersDataModel
        get() {
            val json: String =
                """
                {
                  "buy": [
                    {
                      "volume": 3639000,
                      "count": 1,
                      "rate": 6866795000000,
                      "price": 0,
                      "rate_f": "68667.95",
                      "volume_f": "0.03639"
                    },
                    {
                      "volume": 191622000,
                      "count": 1,
                      "rate": 6866139000000,
                      "price": 0,
                      "rate_f": "68661.39",
                      "volume_f": "1.91622"
                    },
                    {
                      "volume": 2133000,
                      "count": 1,
                      "rate": 6866089000000,
                      "price": 0,
                      "rate_f": "68660.89",
                      "volume_f": "0.02133"
                    },
                    {
                      "volume": 582600,
                      "count": 1,
                      "rate": 6866050000000,
                      "price": 0,
                      "rate_f": "68660.5",
                      "volume_f": "0.005826"
                    },
                    {
                      "volume": 29124400,
                      "count": 1,
                      "rate": 6866002000000,
                      "price": 0,
                      "rate_f": "68660.02",
                      "volume_f": "0.291244"
                    },
                    {
                      "volume": 36253000,
                      "count": 1,
                      "rate": 6865985000000,
                      "price": 0,
                      "rate_f": "68659.85",
                      "volume_f": "0.36253"
                    },
                    {
                      "volume": 14000,
                      "count": 1,
                      "rate": 6865955000000,
                      "price": 0,
                      "rate_f": "68659.55",
                      "volume_f": "0.00014"
                    },
                    {
                      "volume": 308000,
                      "count": 1,
                      "rate": 6865913000000,
                      "price": 0,
                      "rate_f": "68659.13",
                      "volume_f": "0.00308"
                    },
                    {
                      "volume": 60418000,
                      "count": 1,
                      "rate": 6865870000000,
                      "price": 0,
                      "rate_f": "68658.7",
                      "volume_f": "0.60418"
                    },
                    {
                      "volume": 145000,
                      "count": 1,
                      "rate": 6865807000000,
                      "price": 0,
                      "rate_f": "68658.07",
                      "volume_f": "0.00145"
                    },
                    {
                      "volume": 11000,
                      "count": 1,
                      "rate": 6865779000000,
                      "price": 0,
                      "rate_f": "68657.79",
                      "volume_f": "0.00011"
                    },
                    {
                      "volume": 20000,
                      "count": 1,
                      "rate": 6865766000000,
                      "price": 0,
                      "rate_f": "68657.66",
                      "volume_f": "0.0002"
                    },
                    {
                      "volume": 19000,
                      "count": 1,
                      "rate": 6865705000000,
                      "price": 0,
                      "rate_f": "68657.05",
                      "volume_f": "0.00019"
                    },
                    {
                      "volume": 502000,
                      "count": 1,
                      "rate": 6865689000000,
                      "price": 0,
                      "rate_f": "68656.89",
                      "volume_f": "0.00502"
                    },
                    {
                      "volume": 58234000,
                      "count": 1,
                      "rate": 6865638000000,
                      "price": 0,
                      "rate_f": "68656.38",
                      "volume_f": "0.58234"
                    },
                    {
                      "volume": 167518000,
                      "count": 1,
                      "rate": 6865610000000,
                      "price": 0,
                      "rate_f": "68656.1",
                      "volume_f": "1.67518"
                    },
                    {
                      "volume": 20000000,
                      "count": 1,
                      "rate": 6865553000000,
                      "price": 0,
                      "rate_f": "68655.53",
                      "volume_f": "0.2"
                    },
                    {
                      "volume": 145000,
                      "count": 1,
                      "rate": 6865540000000,
                      "price": 0,
                      "rate_f": "68655.4",
                      "volume_f": "0.00145"
                    },
                    {
                      "volume": 14000,
                      "count": 1,
                      "rate": 6865529000000,
                      "price": 0,
                      "rate_f": "68655.29",
                      "volume_f": "0.00014"
                    },
                    {
                      "volume": 30000,
                      "count": 1,
                      "rate": 6865525000000,
                      "price": 0,
                      "rate_f": "68655.25",
                      "volume_f": "0.0003"
                    },
                    {
                      "volume": 60518000,
                      "count": 1,
                      "rate": 6865464000000,
                      "price": 0,
                      "rate_f": "68654.64",
                      "volume_f": "0.60518"
                    },
                    {
                      "volume": 666000,
                      "count": 1,
                      "rate": 6859718000000,
                      "price": 0,
                      "rate_f": "68597.18",
                      "volume_f": "0.00666"
                    },
                    {
                      "volume": 36252000,
                      "count": 1,
                      "rate": 6859712000000,
                      "price": 0,
                      "rate_f": "68597.12",
                      "volume_f": "0.36252"
                    },
                    {
                      "volume": 29000,
                      "count": 1,
                      "rate": 6859250000000,
                      "price": 0,
                      "rate_f": "68592.5",
                      "volume_f": "0.00029"
                    },
                    {
                      "volume": 24822000,
                      "count": 1,
                      "rate": 6858896000000,
                      "price": 0,
                      "rate_f": "68588.96",
                      "volume_f": "0.24822"
                    }
                  ],
                  "sell": [
                    {
                      "volume": 192947000,
                      "count": 1,
                      "rate": 6814191000000,
                      "price": 0,
                      "rate_f": "68141.91",
                      "volume_f": "1.92947"
                    },
                    {
                      "volume": 57817000,
                      "count": 1,
                      "rate": 6814312000000,
                      "price": 0,
                      "rate_f": "68143.12",
                      "volume_f": "0.57817"
                    },
                    {
                      "volume": 47381000,
                      "count": 1,
                      "rate": 6814420000000,
                      "price": 0,
                      "rate_f": "68144.2",
                      "volume_f": "0.47381"
                    },
                    {
                      "volume": 44513000,
                      "count": 1,
                      "rate": 6814626000000,
                      "price": 0,
                      "rate_f": "68146.26",
                      "volume_f": "0.44513"
                    },
                    {
                      "volume": 1911000,
                      "count": 1,
                      "rate": 6814839000000,
                      "price": 0,
                      "rate_f": "68148.39",
                      "volume_f": "0.01911"
                    },
                    {
                      "volume": 1486000,
                      "count": 1,
                      "rate": 6814983000000,
                      "price": 0,
                      "rate_f": "68149.83",
                      "volume_f": "0.01486"
                    },
                    {
                      "volume": 63379000,
                      "count": 1,
                      "rate": 6815140000000,
                      "price": 0,
                      "rate_f": "68151.4",
                      "volume_f": "0.63379"
                    },
                    {
                      "volume": 1778500,
                      "count": 1,
                      "rate": 6815198000000,
                      "price": 0,
                      "rate_f": "68151.98",
                      "volume_f": "0.017785"
                    },
                    {
                      "volume": 1578000,
                      "count": 1,
                      "rate": 6815352000000,
                      "price": 0,
                      "rate_f": "68153.52",
                      "volume_f": "0.01578"
                    },
                    {
                      "volume": 10898000,
                      "count": 1,
                      "rate": 6815579000000,
                      "price": 0,
                      "rate_f": "68155.79",
                      "volume_f": "0.10898"
                    },
                    {
                      "volume": 14835000,
                      "count": 1,
                      "rate": 6816012000000,
                      "price": 0,
                      "rate_f": "68160.12",
                      "volume_f": "0.14835"
                    },
                    {
                      "volume": 29124200,
                      "count": 1,
                      "rate": 6868348000000,
                      "price": 0,
                      "rate_f": "68683.48",
                      "volume_f": "0.291242"
                    },
                    {
                      "volume": 3639000,
                      "count": 1,
                      "rate": 6868383000000,
                      "price": 0,
                      "rate_f": "68683.83",
                      "volume_f": "0.03639"
                    },
                    {
                      "volume": 145000,
                      "count": 1,
                      "rate": 6868395000000,
                      "price": 0,
                      "rate_f": "68683.95",
                      "volume_f": "0.00145"
                    },
                    {
                      "volume": 36396000,
                      "count": 1,
                      "rate": 6868430000000,
                      "price": 0,
                      "rate_f": "68684.3",
                      "volume_f": "0.36396"
                    },
                    {
                      "volume": 7020000,
                      "count": 1,
                      "rate": 6868438000000,
                      "price": 0,
                      "rate_f": "68684.38",
                      "volume_f": "0.0702"
                    },
                    {
                      "volume": 509000,
                      "count": 1,
                      "rate": 6868445000000,
                      "price": 0,
                      "rate_f": "68684.45",
                      "volume_f": "0.00509"
                    },
                    {
                      "volume": 21839000,
                      "count": 1,
                      "rate": 6868490000000,
                      "price": 0,
                      "rate_f": "68684.9",
                      "volume_f": "0.21839"
                    },
                    {
                      "volume": 14000,
                      "count": 1,
                      "rate": 6868516000000,
                      "price": 0,
                      "rate_f": "68685.16",
                      "volume_f": "0.00014"
                    },
                    {
                      "volume": 946000,
                      "count": 1,
                      "rate": 6868542000000,
                      "price": 0,
                      "rate_f": "68685.42",
                      "volume_f": "0.00946"
                    },
                    {
                      "volume": 868694000,
                      "count": 1,
                      "rate": 6868596000000,
                      "price": 0,
                      "rate_f": "68685.96",
                      "volume_f": "8.68694"
                    },
                    {
                      "volume": 7284000,
                      "count": 1,
                      "rate": 6868677000000,
                      "price": 0,
                      "rate_f": "68686.77",
                      "volume_f": "0.07284"
                    },
                    {
                      "volume": 7020000,
                      "count": 1,
                      "rate": 6868707000000,
                      "price": 0,
                      "rate_f": "68687.07",
                      "volume_f": "0.0702"
                    },
                    {
                      "volume": 301936000,
                      "count": 1,
                      "rate": 6868738000000,
                      "price": 0,
                      "rate_f": "68687.38",
                      "volume_f": "3.01936"
                    },
                    {
                      "volume": 1165100,
                      "count": 1,
                      "rate": 6868816000000,
                      "price": 0,
                      "rate_f": "68688.16",
                      "volume_f": "0.011651"
                    }
                  ]
                }
                
                """.trimIndent()

            return Gson().fromJson<MarketOrdersDataModel>(json, MarketOrdersDataModel::class.java)
        }
}
