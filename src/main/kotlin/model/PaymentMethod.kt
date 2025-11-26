package com.kontenery.library.model

import kotlinx.serialization.Serializable

@Serializable
enum class PaymentMethod(
    val polishName: String
) {
    TRANSFER("Przelew"),
    BLIK("BLIK"),
    CASH("Gotówka"),
    OTHER("Inna");

    companion object {
        fun fromName(polishName: String): PaymentMethod? =
            entries.firstOrNull { it.polishName.equals(polishName, ignoreCase = true) }
    }
}