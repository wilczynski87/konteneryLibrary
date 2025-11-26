package com.kontenery.library.model

import com.kontenery.library.serializers.BigDecimalSerializer
import com.kontenery.library.serializers.LocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class PaymentDto(
    val paymentId: String? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val amount: BigDecimal? = null,
    @Serializable(with = LocalDateSerializer::class)
    val date: LocalDate? = null,
    val fromClientId: Long? = null,
    val method: String? = null,
    val toAccount: String? = null,
    val fromAccount: String? = null,
    val title: String? = null,
    val forInvoices: List<String>? = null
)