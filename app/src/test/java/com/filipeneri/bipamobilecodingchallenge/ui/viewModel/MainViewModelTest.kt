package com.filipeneri.bipamobilecodingchallenge.ui.viewModel

import org.junit.Assert
import org.junit.jupiter.api.Assertions.*

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel

    @org.junit.jupiter.api.Test
    fun getUiState() {
    }

    @org.junit.jupiter.api.Test
    fun getNodes() {
    }

    @org.junit.jupiter.api.Test
    fun convertSatsToBitcoin() {
        val sats =viewModel.convertSatsToBitcoin(550000)
        Assert.assertEquals("0,00550000", sats)
    }

    @org.junit.jupiter.api.Test
    fun convertLongToTime() {
    }
}