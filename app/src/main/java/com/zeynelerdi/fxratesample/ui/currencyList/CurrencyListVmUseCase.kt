package com.zeynelerdi.fxratesample.ui.currencyList

import com.zeynelerdi.fxratesample.entity.Amount
import com.zeynelerdi.fxratesample.entity.Currency

object CurrencyListVmUseCase {
    private const val DEFAULT_AMOUNT_IN_BASE_CURRENCY: Amount = 1.0

    fun getAmountInBaseCurrency(
        selectedCurrencyData: SelectedCurrencyData?,
        currencies: List<Currency>
    ): Amount {
        return when (selectedCurrencyData) {
            null -> DEFAULT_AMOUNT_IN_BASE_CURRENCY
            else -> {
                val selectedCurrencyRate = currencies.find { currency ->
                    currency.code == selectedCurrencyData.code
                }?.rate
                requireNotNull(selectedCurrencyRate) {
                    "${selectedCurrencyData.code} is not supported currency."
                }
                selectedCurrencyData.amount / selectedCurrencyRate
            }
        }
    }
}
