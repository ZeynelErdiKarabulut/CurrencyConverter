package com.zeynelerdi.fxratesample.ui.currencyList.adapter

import com.zeynelerdi.fxratesample.entity.Currency
import com.zeynelerdi.fxratesample.entity.CurrencyCode

data class CurrencyListItemRepresentable(
    val flagUrl: String,
    val name: String,
    val code: CurrencyCode,
    var isSelected: Boolean
) {
    constructor(currency: Currency, isSelected: Boolean) : this(
        flagUrl = currency.flagUrl,
        name = currency.name,
        code = currency.code,
        isSelected = isSelected
    )
}
