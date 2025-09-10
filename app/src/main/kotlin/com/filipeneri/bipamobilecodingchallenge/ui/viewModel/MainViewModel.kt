package com.filipeneri.bipamobilecodingchallenge.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeneri.bipamobilecodingchallenge.model.City
import com.filipeneri.bipamobilecodingchallenge.model.Country
import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.repository.MainRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class MainViewModel(private var repository: MainRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        getNodes()
    }

    fun getNodes() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true, msgError = "")
                delay(1000)
                _uiState.value = _uiState.value.copy(
                    nodes = _uiState.value.nodes + repository.getNodes()
                        .filterIndexed { index, _ -> index <= 99 }
                        .sortedByDescending { it.channels },
                    isLoading = false,
                    selected = 0,
                    isRefreshing = false
                )
            } catch (exception: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isRefreshing = false,
                    msgError = exception.message ?: "Erro desconhecido"
                )
            }
        }
    }
    fun clearError() {
        _uiState.value = _uiState.value.copy(msgError = "")
        getNodes()
    }

    fun formatCityCountry(city: City?, country: Country?): String {
        var location = ""
        if (city != null) {
            location += if (!city.ptBR.isNullOrEmpty()) "${city.ptBR}, " else city.en.orEmpty() + ", "
        }
        if (country != null) {
            location += if (!country.ptBR.isNullOrEmpty()) country.ptBR else country.en.orEmpty()
        }
        return location.trimEnd(',', ' ')
    }

    fun convertSatsToBitcoin(sats: Long): String {
        return String.format("%.8f", (sats.toFloat() / 100_000_000))
    }

    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return format.format(date)
    }

    fun setSelected(index: Int) {
        _uiState.value = _uiState.value.copy(selected = index)
    }
}

data class MainUiState(
    var nodes: List<Node> = listOf(),
    var selected: Int = 0,
    var msgError: String = "",
    var isLoading: Boolean = true,
    var isRefreshing: Boolean = false
)
