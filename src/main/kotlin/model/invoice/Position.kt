package com.kontenery.library.model.invoice

import kotlinx.serialization.Serializable

@Serializable
data class Position(
    val productName:String,
    val unitPrice:String,
    val quantity:String,
    val price:String,
    val vatRate:String = "23",
    val vatAmount:String,
    val priceWithVat:String,
) {
    companion object {
        fun toPosition(contract: Contract): Position {
            fun vatCalculate(): BigDecimal {
                val netPrice: BigDecimal = contract.netPrice ?: return BigDecimal.ZERO
                val vatRate: BigDecimal = contract.vatRate
                val vatProcent = vatRate.divide(BigDecimal(100), 2, RoundingMode.HALF_UP)
                return netPrice.multiply(vatProcent).setScale(2, RoundingMode.HALF_UP)
            }

            fun getQuantity():BigDecimal {
                return if(contract.product is Yard) {
                    (contract.product as Yard).quantity?.toBigDecimal() ?: BigDecimal(1)
                } else BigDecimal(1)
            }

            fun unitPriceCalculate(): BigDecimal? {
                return if(contract.product is Yard) {
                    contract.netPrice?.divide(getQuantity())?.setScale(2, RoundingMode.HALF_UP)
                } else contract.netPrice?.setScale(2, RoundingMode.HALF_UP)
            }

            return Position(
                productName = contract.product?.name ?: "Błąd w nazwie",
                unitPrice = unitPriceCalculate().toString() ?: "Błąd w cenie",
                quantity = getQuantity().toString(),
                price = contract.netPrice.toString(),
                vatRate = contract.vatRate.toString(),
                vatAmount = vatCalculate().toString(),
                priceWithVat = contract.netPrice?.plus(vatCalculate()).toString() ?: "Błąd w obliczeniach"
            )
        }
    }
}
