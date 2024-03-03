package entities.bank

import entities.persons.Customer
import enumerations.TypeAccountCreation
import enumerations.TypeCustomer
import enumerations.TypeRequest
import java.util.*

data class Request(
        val idRequest: UUID,
        val customer: Customer,
        val typeRequest: TypeRequest,
        var typeCustomer: TypeCustomer,
        var typeAccountCreation: TypeAccountCreation?
        )
