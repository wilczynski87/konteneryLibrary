package com.kontenery.library.utils.errors

import com.kontenery.library.model.Payment
import kotlinx.serialization.Serializable

@Serializable
class PaymentError(
    override val title: String?,
    override val message: String?,
    val payment: Payment?
) : ErrorMessage

