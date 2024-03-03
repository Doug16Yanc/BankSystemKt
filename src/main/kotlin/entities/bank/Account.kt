package entities.bank

import java.util.*

open class Account(
        open val accountNumber: Int,
        open var apertureAccount: String,
        open var closureAccount: Date?,
        open var password: String,
        open var balance: Double,
        open var movements: List<Movement>? = mutableListOf()
)