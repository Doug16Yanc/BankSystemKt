package entities.persons

import entities.bank.Account
import entities.bank.Movement

data class LegalCustomer (
    override val idCustomer : Int,
    override val nameCustomer : String,
    override var zipCode : String,
    override var telephone : String,
    override var email : String,
    override var income : Double,
    override var username : String,
    override var password : String,
    override var accounts : List<Account>? = mutableListOf(),
    val ein: String,
) :  Customer(idCustomer, nameCustomer, zipCode, telephone, email, income, username, password, accounts)
