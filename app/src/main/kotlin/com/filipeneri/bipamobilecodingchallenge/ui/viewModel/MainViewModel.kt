package com.filipeneri.bipamobilecodingchallenge.ui.viewModel

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeneri.bipamobilecodingchallenge.model.City
import com.filipeneri.bipamobilecodingchallenge.model.Country
import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.repository.MainRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.roundToInt

class MainViewModel(private var repository: MainRepository): ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

     fun getNodes() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy( isLoading = true)
                delay(1000)
                _uiState.value = _uiState.value.copy(
                    nodes = _uiState.value.nodes + repository.getNodes()
                        .filterIndexed { index, element ->
                            index <= 99
                        }.sortedByDescending { it.channels }, isLoading = false, selected = 0
                )
            } catch (exception: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    msgError = exception.message!!
                )
            }
        }
    }
    fun formatCityCountry(city:City?,country: Country?):String{
        var location =""
        if (city != null)
            if (!city.ptBR.isNullOrEmpty()){
                location += "${city.ptBR}, "
            }else if(!city.en.isNullOrEmpty()){
                location += "${city.en}, "
            }
        if (country != null)
            if (!country.ptBR.isNullOrEmpty()){
                location += "${country.ptBR}"
            }else if(!country.en.isNullOrEmpty()){
                location += "${country.en}"
            }

        return location
    }

    fun convertSatsToBitcoin(sats:Long):String{
        return String.format("%.8f",(sats.toFloat() / 100000000))
    }
    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return format.format(date)
    }

    fun setSelected(index: Int) {
        _uiState.value = _uiState.value.copy(
            selected = index
        )

    }

    init {
        getNodes()
    }
}

data class MainUiState(
    var nodes: List<Node> = listOf(),
    var selected: Int = 0,
    var msgError:String ="",
    var isLoading:Boolean = true,
    var isRefreshing:Boolean = false
)