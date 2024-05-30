package com.app.exzi.trade.data

import app.cash.turbine.test
import com.app.exzi.Dummy
import com.app.exzi.core.util.Mapper
import com.app.exzi.trade.data.model.MarketOrdersDataModel
import com.app.exzi.trade.data.remote.MarketOrdersRemoteDataSource
import com.app.exzi.trade.domain.model.MarketOrdersDomainModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MarketOrdersRepositoryImplTest {
    lateinit var sut: MarketOrdersRepositoryImpl

    @RelaxedMockK
    private lateinit var remoteDataSource: MarketOrdersRemoteDataSource

    @RelaxedMockK
    private lateinit var dataModelToDTOMapper: Mapper<MarketOrdersDataModel, MarketOrdersDomainModel>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut =
            MarketOrdersRepositoryImpl(
                remoteDataSource,
                dataModelToDTOMapper
            )
    }

    @Test
    fun `GIVEN pair_id WHEN getOrders from Api THEN return Domain Model orders`(): Unit =
        runBlocking {
            coEvery { remoteDataSource.getOrdersFromApi() } returns Result.success(Dummy.orderBooksRAW)
            every { (dataModelToDTOMapper(Dummy.orderBooksRAW)) } returns Dummy.domainOrderBook

            val result = sut.getOrders()

            result.test {
                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
                awaitComplete()
           }
        }


}