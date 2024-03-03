package services

import entities.bank.Request
import entities.persons.NaturalCustomer
import enumerations.TypeAccountCreation
import enumerations.TypeCustomer
import enumerations.TypeRequest
import utilities.Util.Companion.printMessage
import utilities.Util.Companion.sc
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class NaturalCustomerService {
    companion object{
        var naturalRequests : MutableList<Request> = ArrayList<Request>()
        fun interactesNatural(naturalCustomer : NaturalCustomer){
            printMessage("PAGE NATURAL CUSTOMER")
            println("Welcome, dearest ${naturalCustomer.nameCustomer}.\n");
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
                        sc.nextLine()
                        println("What´s type account?\n C/c - Checking\n S/s - Savings\n")
                        var choose = readLine()?.trim()?.lowercase(Locale.getDefault())
                        when(choose){
                            "c" -> {
                                val request = Request(UUID.randomUUID(), naturalCustomer, TypeRequest.CREATION, TypeCustomer.NATURAL, TypeAccountCreation.CHECKING)
                                println("Creation checking account request sent successfully! Identifier code : ${request.idRequest}")
                                naturalRequests.add(request)
                            }
                            "s" -> {
                                val request = Request(UUID.randomUUID(), naturalCustomer, TypeRequest.CREATION, TypeCustomer.NATURAL, TypeAccountCreation.SAVINGS)
                                println("Creation savings account request sent successfully! Identifier code : ${request.idRequest}")
                                naturalRequests.add(request)
                            }
                            else -> {
                                print("Sorry, however this option´s no existent.\n")
                            }
                        }
                    }
                    2 -> {
                        val accounts = naturalRequests.stream().anyMatch {request -> request.typeRequest ==
                        TypeRequest.CREATION && request.typeCustomer == TypeCustomer.NATURAL}

                        if (accounts){
                            val request = Request(UUID.randomUUID(), naturalCustomer, TypeRequest.DELETION, TypeCustomer.NATURAL, null)
                            println("Deletion account request sent successfully! Identifier code : ${request.idRequest}")
                            naturalRequests.add(request)
                        }
                        else{
                            println("Sorry, however you have no account registered in our system.\n")
                        }
                    }
                    3 -> {
                        val accounts = naturalRequests.stream().anyMatch {request -> request.typeRequest ==
                                TypeRequest.CREATION && request.typeCustomer == TypeCustomer.NATURAL}

                        if (accounts){
                            val request = Request(UUID.randomUUID(), naturalCustomer, TypeRequest.DISABILITATION, TypeCustomer.NATURAL, null)
                            println("Disabilitation account request sent successfully! Identifier code : ${request.idRequest}")
                            naturalRequests.add(request)
                        }
                        else{
                            println("Sorry, however you have no account registered in our system.\n")
                        }
                    }
                    4 -> {
                        queryDataNatural(naturalCustomer)
                    }
                    5 -> {
                        updateDataNatural(naturalCustomer)
                    }
                    6 -> {

                    }
                    7 -> {

                    }
                }
            } while(true)
        }
        fun queryDataNatural(naturalCustomer : NaturalCustomer) : Boolean {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            val currentTime= LocalDateTime.now().format(formatter)
            printMessage("PROOF RECORD NATURAL CUSTOMER\n\n" +
                    "   Data customer   \n\n" +
                    "   > Id : ${naturalCustomer.idCustomer}\n" +
                    "   > Name : ${naturalCustomer.nameCustomer}\n" +
                    "   > Email : ${naturalCustomer.email}\n" +
                    "   > Income : ${naturalCustomer.income}\n" +
                    "   > Telephone : ${naturalCustomer.telephone}\n" +
                    "   > SSN : ${naturalCustomer.ssn}\n\n" +
                    "   Data operation  \n\n" +
                    "   > Operation code : ${UUID.randomUUID()}\n" +
                    "   > Data and time : ${currentTime}")
            return true
        }
        fun updateDataNatural(naturalCustomer: NaturalCustomer) : Boolean{
            printMessage("You have permission to update only email, zip code, telephone, username and password.\n" +
                    "Observation : Income can be updated after analisys clerk from bank system.\n")
            println("   E/e - Email\n   Z/z - Zip code\n    T/t - Telephone\n   U/u - Username\n    P/p - Password\n    I/i - Income\n")
            var option = readLine()?.trim()?.lowercase(Locale.getDefault())

            when(option){
                "e" -> {
                    println("New email : ")
                    var newEmail = readLine()
                    if (newEmail != null) {
                        naturalCustomer.email = newEmail
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "z" -> {
                    println("New zip code : ")
                    var newZip = readLine()
                    if (newZip != null) {
                        naturalCustomer.zipCode = newZip
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "t" -> {
                    println("New telephone : ")
                    var newTelephone = readLine()
                    if (newTelephone != null) {
                        naturalCustomer.telephone = newTelephone
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "u" -> {
                    println("New username : ")
                    var newUsername = readLine()
                    if (newUsername != null) {
                        naturalCustomer.username = newUsername
                    }
                    else {
                        println("Operation unsuccessfully!\n")
                    }
                }
                "p" -> {
                    println("New password : ")
                    var newPassword = readLine()
                    if (newPassword != null) {
                        naturalCustomer.password = newPassword
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