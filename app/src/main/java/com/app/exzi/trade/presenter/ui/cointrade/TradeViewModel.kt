package com.app.exzi.trade.presenter.ui.cointrade

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.exzi.appnavigation.Screens
import com.app.exzi.core.di.IoDispatcher
import com.app.exzi.core.navigator.Navigator
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.SingleMarketDetailUseCase
import com.app.exzi.trade.domain.model.MarketDomainModel
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.domain.repositories.MarketOrdersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO adding useCase instead of using repository
@HiltViewModel
class TradeViewModel
    @Inject
    constructor(
        private val orderBook: MarketOrdersRepository,
        private val marketDetail: SingleMarketDetailUseCase,
        private val navigator: Navigator,
        @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    ) :
    ViewModel() {
        private val _askOrderBook = MutableStateFlow<List<MarketOrderDomainModel>>(emptyList())
        val askOrderBook: StateFlow<List<MarketOrderDomainModel>> = _askOrderBook.asStateFlow()

        private val _bidOrderBook = MutableStateFlow<List<MarketOrderDomainModel>>(emptyList())
        val bidOrderBook: StateFlow<List<MarketOrderDomainModel>> = _bidOrderBook.asStateFlow()

        private val _marketDetailData =
            MutableStateFlow<ViewStates<MarketDomainModel>>(ViewStates.Loading)
        val marketDetailData: StateFlow<ViewStates<MarketDomainModel>> = _marketDetailData.asStateFlow()

        fun navigateToDetail() {
            navigator.navigate(Screens.CoinDetail.route())
        }

        // TODO it could be change when user select a pair and fire a new request and cancel previues request.
        private val selectedPair =
            MutableStateFlow("1041")

        init {
            startPullingData()
        }

        private fun startPullingData() {
            viewModelScope.launch(ioDispatcher) {
                orderBook.getOrders(selectedPair.value).collectLatest {
                    _askOrderBook.value = it.getOrNull()?.ask ?: listOf()
                    _bidOrderBook.value = it.getOrNull()?.bid ?: listOf()
                    // TODO errors should be handled.
                }
            }

            viewModelScope.launch {
                marketDetail(selectedPair.value).flowOn(ioDispatcher).collectLatest {
                    it.onSuccess {
                        _marketDetailData.value = ViewStates.Success(it)
                    }.onFailure {
                        _marketDetailData.value = ViewStates.Error(it.message ?: "")
                        cancel()
                        // TODO when raising an error i stop pulling from server until user see the error and retry manually. in this case it just stop the pulling.
                    }
                }
            }
        }
    }
