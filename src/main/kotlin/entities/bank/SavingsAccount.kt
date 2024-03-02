package entities.bank

import java.util.*

data class SavingsAccount(
    override val accountNumber : Int,
    override var apertureAccount : Date,
    override var closureAccount : Date,
    override var password : String,
    override var balance : Double,
    override var movements : List<Movement> = mutableListOf(),
    var birthdayAccount : Date,
    var yield : Double
) : Account(accountNumber, apertureAccount, closureAccount, password, balance)

