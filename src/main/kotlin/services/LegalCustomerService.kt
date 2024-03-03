package services

import entities.persons.LegalCustomer
import utilities.Util.Companion.printMessage
import utilities.Util.Companion.sc

class LegalCustomerService {
    companion object{
        fun interactesLegal(legalCustomer: LegalCustomer){
            printMessage("PAGE LEGAL CUSTOMER\n")
            println("Welcome, dearest ${legalCustomer.nameCustomer}.\n");
            do {
                println("        Choose an option        \n" +
                        "                   REQUESTS\n\n" +
                        "                   1 - Creation of account\n" +
                        "                   2 - Delete an account\n" +
                        "                   3 - Disable an account\n\n" +
                        "                   PERSONAL DATA\n\n" +
                        "                   4 - Query data\n" +
                        "                   5 - Update\n\n" +
                        "                   SYSTEM OPERATIONS\n\n" +
                        "                   6 - Go to the financial operations\n" +
                        "                   7 - Return to the initial menu\n");
                var option = sc.nextInt()

                when(option){
                    1 -> {

                    }
                    2 -> {

                    }
                    3 -> {

                    }
                    4 -> {

                    }
                    5 -> {

                    }
                    6 -> {

                    }
                    7 -> {

                    }
                }
            } while(true)
        }
    }
}