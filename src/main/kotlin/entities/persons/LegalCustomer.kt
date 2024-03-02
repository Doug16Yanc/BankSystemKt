package entities.persons

data class LegalCustomer (
    override val idCustomer : Int,
    override val nameCustomer : String,
    override var zipCode : String,
    override var telephone : String,
    override var email : String,
    override var income : Double,
    override var username : String,
    override var password : String,
    val ein: Long
) :  Customer(idCustomer, nameCustomer, zipCode, telephone, email, income, username, password)
