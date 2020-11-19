package com.zeynelerdi.fxratesample.ui.currencyList

import com.zeynelerdi.fxratesample.ui.currencyList.adapter.CurrencyListItemRepresentable

sealed class CurrencyListUiState {
    object InitialLoad : CurrencyListUiState()

    data class UpdateList(val currencyList: List<CurrencyListItemRepresentable>) :
        CurrencyListUiState()
}

sealed class ErrorViewState {
    object ShowError : ErrorViewState()
    object HideError : ErrorViewState()
}
