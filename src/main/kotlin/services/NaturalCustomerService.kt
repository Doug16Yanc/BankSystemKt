package services

import entities.persons.NaturalCustomer
import utilities.Util.Companion.printMessage

class NaturalCustomerService {
    companion object{
        fun interactesNatural(naturalCustomer : NaturalCustomer){
            printMessage("PAGE NATURAL CUSTOMER")
        }
    }
}