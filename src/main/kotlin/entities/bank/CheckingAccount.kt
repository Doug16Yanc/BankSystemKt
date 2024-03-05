package entities.bank

import enumerations.AccountSituation
import java.util.*

data class CheckingAccount(
        override val accountNumber: Int,
        override var apertureAccount: String,
        override var closureAccount: Date?,
        override var password: String,
        override var balance: Double,
        override var accountSituation : AccountSituation,
        override var movements: List<Movement>? = mutableListOf(),
        var limitAccount: Double
) : Account(accountNumber, apertureAccount, closureAccount, password, balance, accountSituation)
