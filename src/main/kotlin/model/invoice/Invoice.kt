package com.kontenery.library.model.invoice

import com.kontenery.library.serializers.LocalDateSerializer
import com.kontenery.library.utils.InvoiceType
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Invoice(
    val invoiceNumber:String?,
    val invoiceTitle:String? = "Faktura VAT",
    @Serializable(with = LocalDateSerializer::class)
    val invoiceDate: LocalDate?,
    val seller: Subject.Seller?,
    val customer: Subject.Customer?,
    val products:List<Position> = mutableListOf(),
    val vatAmountSum:String?,
    val priceSum:String?,
    val priceWithVatSum:String?,
    @Serializable(with = LocalDateSerializer::class)
    val paymentDay:LocalDate?,
    val mainAccount:String = "50 1950 0001 2006 0023 6241 0001",
    @Serializable(with = LocalDateSerializer::class)
    val invoiceSendToClient: LocalDate?,
    val type: String? = InvoiceType.PERIODIC.name,
    val vatApply: Boolean,
) {
}