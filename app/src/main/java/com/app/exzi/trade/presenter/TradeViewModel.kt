package com.app.exzi.trade.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.CandlesRepository
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.domain.MarketOrdersRepository
import com.app.exzi.trade.domain.candle.CandleDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TradeViewModel @Inject constructor(
    private val orderBook: MarketOrdersRepository,
    private val candlesRepository: CandlesRepository
) :
    ViewModel() {
    private val _askOrderBook = MutableStateFlow<List<MarketOrderDomainModel>>(emptyList())
    val askOrderBook: StateFlow<List<MarketOrderDomainModel>> = _askOrderBook.asStateFlow()

    private val _bidOrderBook = MutableStateFlow<List<MarketOrderDomainModel>>(emptyList())
    val bidOrderBook: StateFlow<List<MarketOrderDomainModel>> = _bidOrderBook.asStateFlow()

    private val _candles = MutableStateFlow<ViewStates<CandleDomainModel>>(ViewStates.Loading)
    val candles: StateFlow<ViewStates<CandleDomainModel>> = _candles.asStateFlow()

    init {
        viewModelScope.launch {
            orderBook.getOrders("1041").collectLatest {
                _askOrderBook.value = it.getOrNull()?.ask ?: listOf()
                _bidOrderBook.value = it.getOrNull()?.bid ?: listOf()
            }
        }
        viewModelScope.launch {
            candlesRepository.getCandlesData("BTCUSDT").onSuccess {
                _candles.value = ViewStates.Success(it)
            }.onFailure {
                _candles.value = ViewStates.Error(it.message ?: "")
            }
        }
    }
}