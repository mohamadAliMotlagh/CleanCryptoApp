package com.app.exzi.trade.data

import app.cash.turbine.test
import com.app.exzi.Dummy
import com.app.exzi.core.util.Mapper
import com.app.exzi.trade.data.model.MarketOrdersDataModel
import com.app.exzi.trade.data.remote.orderbook.MarketOrdersRemoteDataSource
import com.app.exzi.trade.domain.model.MarketOrdersDomainModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
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
                dataModelToDTOMapper,
            )
    }

    @Test
    fun `GIVEN pair_id WHEN getOrders from Api successfully THEN return Domain Model orders`(): Unit =
        runTest {
            val pariID = "1041"
            coEvery { remoteDataSource.getOrdersFromApi(pariID) } returns Result.success(Dummy.orderBooksRAW)
            every { (dataModelToDTOMapper(Dummy.orderBooksRAW)) } returns Dummy.domainOrderBook

            val result = sut.getOrders(pariID)

            result.test {
                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
            }
        }

    @Test
    fun `GIVEN pair_id WHEN getOrders from Api failed THEN return  Error`(): Unit =
        runTest {
            val pariID = "1041"
            coEvery { remoteDataSource.getOrdersFromApi(pariID) } returns Result.failure(Throwable("ERROR"))

            val result = sut.getOrders(pariID)

            result.test {
                assertEquals(true, awaitItem().isFailure)
            }
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `GIVEN a pair_id WHEN getOrders called Api with many times repeat and delay THEN return many times orderDomain`(): Unit =
        runTest {
            val pariID = "1041"
            coEvery { remoteDataSource.getOrdersFromApi(pariID) } returns Result.success(Dummy.orderBooksRAW)
            every { (dataModelToDTOMapper(Dummy.orderBooksRAW)) } returns Dummy.domainOrderBook

            val result = sut.getOrders(pariID)

            result.test {
                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
            }
        }
}
