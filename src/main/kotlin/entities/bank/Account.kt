package entities.bank

import enumerations.AccountSituation
import java.util.*

open class Account(
        open val accountNumber: Int,
        open var apertureAccount: String,
        open var closureAccount: Date?,
        open var password: String,
        open var balance: Double,
        open var accountSituation : AccountSituation,
        open var movements: List<Movement>? = mutableListOf()
)