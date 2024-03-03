package services

import entities.persons.LegalCustomer
import utilities.Util.Companion.printMessage

class LegalCustomerService {
    companion object{
        fun interactesLegal(legalCustomer: LegalCustomer){
            printMessage("PAGE LEGAL CUSTOMER\n")
        }
    }
}