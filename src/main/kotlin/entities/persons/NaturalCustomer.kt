package entities.persons

import entities.bank.Account

data class NaturalCustomer(
    override val idCustomer : Int,
    override val nameCustomer : String,
    override var zipCode : String,
    override var telephone : String,
    override var email : String,
    override var income : Double,
    override var username : String,
    override var password : String,
    override var accounts : List<Account>? = mutableListOf(),
    val ssn: String
) :  Customer(idCustomer, nameCustomer, zipCode, telephone, email, income, username, password, accounts)
