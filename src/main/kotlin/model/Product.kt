package com.kontenery.library.model

import com.kontenery.library.utils.ProductType
import com.kontenery.library.serializers.ByteArrayAsBase64Serializer
import com.kontenery.library.serializers.LocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.*

@Serializable
@Polymorphic
@SerialName("PRODUCT")
sealed class Product {
    abstract val id: Long?
    abstract val name: String?
    abstract val location: String?
    abstract val type: ProductType?

    @Serializable
    @SerialName("CONTAINER")
    data class Container(
        override val id: Long? = null,
        override val name: String? = null,
        override val location: String? = null,
        override val type: ProductType? = ProductType.CONTAINER,
        val length: String? = null,
        val height: String? = null,
        val color: String? = null,
        @Serializable(with = LocalDateSerializer::class)
        val acquireDate: LocalDate? = null,
        @Serializable(with = LocalDateSerializer::class)
        val lastPainting: LocalDate? = null,
        val description: String? = null,
        @Serializable(with = ByteArrayAsBase64Serializer::class) // Custom serializer for byte arrays
        val photo: ByteArray? = null,
    ): Product() {
        val uom: String = "m2"
    }

    @Serializable
    @SerialName("YARD")
    data class Yard(
        override val id: Long? = null,
        override val name: String? = null,
        override val location: String? = null,
        override val type: ProductType? = ProductType.CONTAINER,
        val quantity: Long? = null
    ): Product() {
        val uom: String = "m2"
    }

}