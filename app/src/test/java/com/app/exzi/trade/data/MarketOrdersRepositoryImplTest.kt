package com.app.exzi.trade.data

//class MarketOrdersRepositoryImplTest {
//    lateinit var sut: MarketOrdersRepositoryImpl
//
//
//    @RelaxedMockK
//    private lateinit var remoteDataSource: MarketOrdersRemoteDataSource
//
//    @RelaxedMockK
//    private lateinit var dataModelToDTOMapper: Mapper<MarketOrdersDataModel, MarketOrdersDomainModel>
//
//    @Before
//    fun setUp() {
//        MockKAnnotations.init(this)
//        sut =
//            MarketOrdersRepositoryImpl(
//                remoteDataSource,
//                dataModelToDTOMapper
//            )
//    }
//
//    @Test
//    fun `GIVEN pair_id WHEN getOrders from Api successfully THEN return Domain Model orders`(): Unit =
//        runTest {
//            val pariID = "1041"
//            coEvery { remoteDataSource.getOrdersFromApi(pariID) } returns Result.success(Dummy.orderBooksRAW)
//            every { (dataModelToDTOMapper(Dummy.orderBooksRAW)) } returns Dummy.domainOrderBook
//
//            val result = sut.getOrders(pariID)
//
//            result.test {
//                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
//            }
//        }
//
//    @Test
//    fun `GIVEN pair_id WHEN getOrders from Api failed THEN return  Error`(): Unit =
//        runTest {
//            val pariID = "1041"
//            coEvery { remoteDataSource.getOrdersFromApi(pariID) } returns Result.failure(Throwable("ERROR"))
//
//            val result = sut.getOrders(pariID)
//
//            result.test {
//                assertEquals(true, awaitItem().isFailure)
//            }
//        }
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Test
//    fun `GIVEN a pair_id WHEN getOrders called Api with many times repeat and delay THEN return many times orderDomain`(): Unit =
//        runTest {
//            val pariID = "1041"
//            coEvery { remoteDataSource.getOrdersFromApi(pariID) } returns Result.success(Dummy.orderBooksRAW)
//            every { (dataModelToDTOMapper(Dummy.orderBooksRAW)) } returns Dummy.domainOrderBook
//
//            val result = sut.getOrders(pariID)
//
//            result.test {
//                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
//                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
//                assertEquals(Dummy.domainOrderBook.ask.size, awaitItem().getOrNull()?.ask?.size)
//            }
//        }
//}