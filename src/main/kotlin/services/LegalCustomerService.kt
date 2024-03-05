package services

import application.main
import entities.bank.Request
import entities.persons.LegalCustomer
import enumerations.TypeAccountCreation
import enumerations.TypeCustomer
import enumerations.TypeRequest
import services.CustomerService.Companion.doAccessAccountLegal
import services.FinancialService.Companion.driveFinancialOperations
import utilities.Util.Companion.printMessage
import utilities.Util.Companion.sc
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class LegalCustomerService {
    companion object{
        public var legalRequests : MutableList<Request> = ArrayList<Request>()
        fun interactesLegal(legalCustomer: LegalCustomer){
            printMessage("PAGE LEGAL CUSTOMER\n")
            println("Welcome, dearest ${legalCustomer.nameCustomer}.\n");
            do {
                println("        Choose an option        \n" +
                        "                   REQUESTS\n\n" +
                        "                   1 - Creation of account\n" +
                        "                   2 - Delete an account\n" +
                        "                   3 - Disable an account\n" +
                        "                   4 - Access an account\n\n" +
                        "                   PERSONAL DATA\n\n" +
                        "                   4 - Query data\n" +
                        "                   5 - Update\n\n" +
                        "                   SYSTEM OPERATIONS\n\n" +
                        "                   6 - Go to the financial operations\n" +
                        "                   7 - Return to the initial menu\n");
                var option = sc.nextInt()

                when(option){
                    1 -> {
                        sc.nextLine()
                        println("What´s type account?\n C/c - Checking\n S/s - Savings\n")
                        var choose = readLine()?.trim()?.lowercase(Locale.getDefault())
                        when(choose){
                            "c" -> {
                                val request = Request(UUID.randomUUID(), legalCustomer, TypeRequest.CREATION, TypeCustomer.LEGAL, TypeAccountCreation.CHECKING)
                                println("Creation checking account request sent successfully! Identifier code : ${request.idRequest}")
                                legalRequests.add(request)
                            }
                            "s" -> {
                                val request = Request(UUID.randomUUID(), legalCustomer, TypeRequest.CREATION, TypeCustomer.LEGAL, TypeAccountCreation.SAVINGS)
                                println("Creation savings account request sent successfully! Identifier code : ${request.idRequest}")
                                legalRequests.add(request)
                            }
                            else -> {
                                print("Sorry, however this option´s no existent.\n")
                            }
                        }
                    }
                    2 -> {
                        val accounts = legalRequests.stream().anyMatch { request -> request.typeRequest ==
                                TypeRequest.CREATION && request.typeCustomer == TypeCustomer.LEGAL}

                        if (accounts){
                            val request = Request(UUID.randomUUID(), legalCustomer, TypeRequest.DELETION, TypeCustomer.LEGAL, null)
                            println("Deletion account request sent successfully! Identifier code : ${request.idRequest}")
                            legalRequests.add(request)
                        }
                        else{
                            println("Sorry, however you have no account registered in our system.\n")
                        }
                    }
                    3 -> {
                        val accounts = legalRequests.stream().anyMatch { request -> request.typeRequest ==
                                TypeRequest.CREATION && request.typeCustomer == TypeCustomer.LEGAL}

                        if (accounts){
                            val request = Request(UUID.randomUUID(), legalCustomer, TypeRequest.DISABILITATION, TypeCustomer.LEGAL, null)
                            println("Disabilitation account request sent successfully! Identifier code : ${request.idRequest}")
                            legalRequests.add(request)
                        }
                        else{
                            println("Sorry, however you have no account registered in our system.\n")
                        }
                    }
                    4 -> {
                        doAccessAccountLegal(legalCustomer)
                    }
                    5 -> {
                        queryDataLegal(legalCustomer)
                    }
                    6 -> {
                        updateDataLegal(legalCustomer)
                    }
                    7 -> {
                        driveFinancialOperations()
                    }
                    8 -> {
                        main()
                        break
                    }
                }
            } while(true)
        }
        fun queryDataLegal(legalCustomer: LegalCustomer) : Boolean {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            val currentTime= LocalDateTime.now().format(formatter)
            printMessage("PROOF RECORD NATURAL CUSTOMER\n\n" +
                    "   Data customer   \n\n" +
                    "   > Id : ${legalCustomer.idCustomer}\n" +
                    "   > Name : ${legalCustomer.nameCustomer}\n" +
                    "   > Email : ${legalCustomer.email}\n" +
                    "   > Income : ${legalCustomer.income}\n" +
                    "   > Telephone : ${legalCustomer.telephone}\n" +
                    "   > EIN : ${legalCustomer.ein}\n\n" +
                    "   Data operation  \n\n" +
                    "   > Operation code : ${UUID.randomUUID()}\n" +
                    "   > Data and time : ${currentTime}")
            return true
        }
        fun updateDataLegal(legalCustomer: LegalCustomer) : Boolean{
            printMessage("You have permission to update only email, zip code, telephone, username and password.\n" +
                    "Observation : Income can be updated after analisys clerk from bank system.\n")
            println("   E/e - Email\n   Z/z - Zip code\n    T/t - Telephone\n   U/u - Username\n    P/p - Password\n    I/i - Income\n")
            var option = readLine()?.trim()?.lowercase(Locale.getDefault())

            when(option){
                "e" -> {
                    println("New email : ")
                    var newEmail = readLine()
                    if (newEmail != null) {
                        legalCustomer.email = newEmail
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "z" -> {
                    println("New zip code : ")
                    var newZip = readLine()
                    if (newZip != null) {
                        legalCustomer.zipCode = newZip
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "t" -> {
                    println("New telephone : ")
                    var newTelephone = readLine()
                    if (newTelephone != null) {
                        legalCustomer.telephone = newTelephone
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "u" -> {
                    println("New username : ")
                    var newUsername = readLine()
                    if (newUsername != null) {
                        legalCustomer.username = newUsername
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "p" -> {
                    println("New password : ")
                    var newPassword = readLine()
                    if (newPassword != null) {
                        legalCustomer.password = newPassword
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "i" -> {
                    println("Your request will be sent to clerk from system bank for analysis and with his decision, you can" +
                            "see the update status.\n")
                    println("Description of update income request:")
                    var description = sc.nextLine()

                    println("New income value : ")
                    var newIncome = sc.nextDouble()
                    sc.nextLine()
                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
            return true
        }
    }
}