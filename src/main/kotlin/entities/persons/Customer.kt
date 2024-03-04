package entities.persons

import entities.bank.Account

open class Customer(
    open val idCustomer : Int,
    open val nameCustomer : String,
    open var zipCode : String,
    open var telephone : String,
    open var email : String,
    open var income : Double,
    open var username : String,
    open var password : String,
    open var accounts : List<Account>? = mutableListOf()
)
