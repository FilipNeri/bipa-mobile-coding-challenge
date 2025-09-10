package com.filipeneri.bipamobilecodingchallenge.ui.viewModel
import com.filipeneri.bipamobilecodingchallenge.model.City
import com.filipeneri.bipamobilecodingchallenge.model.Country
import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.repository.MainRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.*
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever


@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private lateinit var repository: MainRepository
    private lateinit var viewModel: MainViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = mock()
        viewModel = MainViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getNodes should update UIState with nodes`() = runTest {
        val fakeNodes = listOf(
            Node(
                publicKey = "key1",
                alias = "Node 1",
                channels = 50,
                capacity = 1000,
                firstSeen = 1000L,
                updatedAt = 2000L,
                city = City("Cidade1", "City1", "Ciudad1", "Ville1", "都市1", "Cidade1", "Город1", "城市1"),
                country = Country("País1", "Country1", "País1", "Pays1", "国1", "País1", "Страна1", "国家1")
            ),
            Node(
                publicKey = "key2",
                alias = "Node 2",
                channels = 150,
                capacity = 2000,
                firstSeen = 1100L,
                updatedAt = 2100L,
                city = City("Cidade2", "City2", "Ciudad2", "Ville2", "都市2", "Cidade2", "Город2", "城市2"),
                country = Country("País2", "Country2", "País2", "Pays2", "国2", "País2", "Страна2", "国家2")
            ),
            Node(
                publicKey = "key3",
                alias = "Node 3",
                channels = 100,
                capacity = 1500,
                firstSeen = 1200L,
                updatedAt = 2200L,
                city = City("Cidade3", "City3", "Ciudad3", "Ville3", "都市3", "Cidade3", "Город3", "城市3"),
                country = Country("País3", "Country3", "País3", "Pays3", "国3", "País3", "Страна3", "国家3")
            )
        )
        whenever(repository.getNodes()).thenReturn(fakeNodes)

        viewModel.getNodes()
        testDispatcher.scheduler.advanceUntilIdle() //exec corrotina
        val uiState = viewModel.uiState.value
        assertFalse(uiState.isLoading)
        assertEquals(0, uiState.selected)
        assertEquals(3, uiState.nodes.size)
        assertEquals("", uiState.msgError)
    }

    @Test
    fun `getNodes should handle error`() = runTest {
        whenever(repository.getNodes()).thenThrow(RuntimeException("Network error"))
        viewModel.getNodes()
        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.uiState.value
        assertFalse(uiState.isLoading)
        assertEquals("Network error", uiState.msgError)
        assertTrue(uiState.nodes.isEmpty())
    }
}
