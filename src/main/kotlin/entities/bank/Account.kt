package entities.bank

import java.util.*
import kotlin.collections.ArrayList

open class Account (
    open val accountNumber : Int,
    open var apertureAccount : Date,
    open var closureAccount : Date,
    open var password : String,
    open var balance : Double,
    open var movements : List<Movement> = mutableListOf()
)