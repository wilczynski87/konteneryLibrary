package com.kontenery.library.model

import com.kontenery.library.serializers.BigDecimalSerializer
import com.kontenery.library.serializers.LocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class Contract(
    val id: Long? = null,
    var client: Client? = null,
    var product: Product? = null,
    @Serializable(with = LocalDateSerializer::class)
    var startDate: LocalDate? = null,
    @Serializable(with = LocalDateSerializer::class)
    var endDate: LocalDate? = null,
    @Serializable(with = BigDecimalSerializer::class)
    var netPrice: BigDecimal? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val vatRate: BigDecimal = BigDecimal(23),
    var needInvoice: Boolean? = null,
    var deposit: Deposit? = null,
) {
    fun toContractDTO(): ContractDto =
        ContractDto(
            id = id,
            client = client?.id,
            product = product?.id,
            startDate = startDate,
            endDate = endDate,
            netPrice = netPrice,
            vatRate = vatRate,
            needInvoice = needInvoice
        )
}

@Serializable
data class ContractDto(
    val id: Long? = null,
    var client: Long? = null,
    var product: Long? = null,
    @Serializable(with = LocalDateSerializer::class)
    var startDate: LocalDate? = null,
    @Serializable(with = LocalDateSerializer::class)
    var endDate: LocalDate? = null,
    @Serializable(with = BigDecimalSerializer::class)
    var netPrice: BigDecimal? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val vatRate: BigDecimal = BigDecimal(23),
    var needInvoice: Boolean? = null,
    var deposit: Deposit? = null,
) {

}