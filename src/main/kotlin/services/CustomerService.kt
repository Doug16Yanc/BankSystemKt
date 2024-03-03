package services

import application.main
import entities.persons.LegalCustomer
import entities.persons.NaturalCustomer
import repositories.GenerationId
import utilities.Util.Companion.printMessage
import utilities.Util.Companion.sc
import java.time.LocalDateTime
import java.util.*
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList

class CustomerService {
    companion object {
        private var legals: MutableList<LegalCustomer> = ArrayList<LegalCustomer>()
        private var naturals: MutableList<NaturalCustomer> = ArrayList<NaturalCustomer>()
        fun asksAboutCustomer() {
            printMessage("Welcome to our page of customers\n")
            println("Have you already registered in our system?\n  Y/y - Yes\n  N/n - Not\n")
            var option = readLine()?.trim()?.lowercase(Locale.getDefault())

            when(option){
                "y" -> {
                    doLoginCustomer(legals, naturals)
                }
                "n" -> {
                    recordCustomer(legals, naturals)
                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
        }
        fun doLoginCustomer(legals: MutableList<LegalCustomer>, naturals: MutableList<NaturalCustomer>) {
            printMessage("Page of customer login\n")
            println("Who are you?\n L/l - Legal\n N/n - Natural\n")
            var option = readLine()?.trim()?.lowercase(Locale.getDefault())

            when(option){
                "l" -> {
                    doLoginLegal(legals)
                }
                "n" -> {
                    doLoginNatural(naturals)
                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
        }

        fun doLoginLegal(legals: MutableList<LegalCustomer>) {
            var attempts : Int = 3
            var found : Boolean = false
            printMessage("Page of login legal customer\n")
            sc.nextLine()
            println("Enter your id:")
            val id = sc.nextInt()

            val validation = legals.find {it.idCustomer == id}

            if (validation != null){
                println("Enter your username and password:")
                do{
                    println("Username : ")
                    var username = readLine()
                    println("Password : ")
                    var password = readLine()

                    for (legal in legals){
                        if (legal.username.equals(username) && legal.password.equals(password)){
                            found = true
                        }
                    }
                    if (found){
                        println("Login successfully!\n")
                    }
                    else{
                        println("Credentials not recognized!\n")
                        attempts--
                    }
                } while(attempts > 0)

            }
            else {
               println("Customer not found.\n")
           }
        }
        fun doLoginNatural(naturals: MutableList<NaturalCustomer>) {
            var attempts : Int = 3
            var found : Boolean = false
            printMessage("Page of login natural customer\n")
            sc.nextLine()
            println("Enter your id:")
            val id = sc.nextInt()

            val validation = naturals.find {it.idCustomer == id}
            if (validation != null){
                println("Enter your username and password:")
                do{
                    println("Username : ")
                    var username = readLine()
                    println("Password : ")
                    var password = readLine()

                    for (natural in naturals){
                        if (natural.username.equals(username) && natural.password.equals(password)){
                            found = true
                        }
                    }
                    if (found){
                        println("Login successfully!\n")
                    }
                    else{
                        println("Credentials not recognized!\n")
                        attempts--
                    }
                } while(attempts > 0)

            }
            else {
                println("Customer not found.\n")
            }
        }
        fun recordCustomer(legals: MutableList<LegalCustomer>, naturals: MutableList<NaturalCustomer>) {
            printMessage("Page of customer registers\n")
            println("Are you legal or natural person?\n" +
                    " L/l - Legal \n" +
                    " N/n - Natural\n")
            var option = sc.nextLine()

            when(option.lowercase(Locale.getDefault())){
                "l" -> {
                    recordCustomerLegal(legals)
                }
                "n" -> {
                    recordCustomerNatural(naturals)
                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
        }
        fun recordCustomerLegal(legals: MutableList<LegalCustomer>) {
            val id = GenerationId.generateIdLegal(legals)
            println("Name : ")
            val name = sc.nextLine()
            println("Zip code : ")
            val zipCode = sc.nextLine()
            println("Telephone : ")
            val telephone = sc.nextLine()
            println("Email : ")
            val email = sc.nextLine()
            println("Income : ")
            val income = sc.nextDouble()
            sc.nextLine()
            println("Username : ")
            val username = sc.nextLine()
            println("Password : ")
            val password = sc.nextLine()
            println("EIN : ")
            val ein = sc.nextLine()

            val legalCustomer = LegalCustomer(id, name, zipCode, telephone, email, income, username, password, ein)
            proofRecordLegal(legalCustomer)
            legals.add(legalCustomer)
            main()
        }

        fun recordCustomerNatural(naturals: MutableList<NaturalCustomer>) {
            val id = GenerationId.generateIdNatural(naturals)
            println("Name : ")
            var name = sc.nextLine()
            println("Zip code : ")
            var zipCode = sc.nextLine()
            println("Telephone : ")
            var telephone = sc.nextLine()
            println("Email : ")
            var email = sc.nextLine()
            println("Income : ")
            var income = sc.nextDouble()
            sc.nextLine()
            println("Username : ")
            var username = sc.nextLine()
            println("Password : ")
            var password = sc.nextLine()
            println("SSN : ")
            var ssn = sc.nextLine()
            val naturalCustomer = NaturalCustomer(id, name, zipCode, telephone, email, income, username, password, ssn)
            proofRecordNatural(naturalCustomer)
            naturals.add(naturalCustomer)
            main()
        }

        fun proofRecordLegal(legalCustomer : LegalCustomer){
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            val currentTime = LocalDateTime.now().format(formatter)
            printMessage("PROOF RECORD LEGAL CUSTOMER\n\n" +
                    "   Data customer   \n\n" +
                    "   > Id : ${legalCustomer.idCustomer}\n" +
                    "   > Name : ${legalCustomer.nameCustomer}\n" +
                    "   > Email : ${legalCustomer.email}\n" +
                    "   > Telephone : ${legalCustomer.telephone}\n" +
                    "   > EIN : ${legalCustomer.ein}\n\n" +
                    "   Data operation  \n\n" +
                    "   > Operation code : ${UUID.randomUUID()}\n" +
                    "   > Data and time : ${currentTime}")
        }
        fun proofRecordNatural(naturalCustomer : NaturalCustomer) {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            val currentTime= LocalDateTime.now().format(formatter)
            printMessage("PROOF RECORD NATURAL CUSTOMER\n\n" +
                    "   Data customer   \n\n" +
                    "   > Id : ${naturalCustomer.idCustomer}\n" +
                    "   > Name : ${naturalCustomer.nameCustomer}\n" +
                    "   > Email : ${naturalCustomer.email}\n" +
                    "   > Telephone : ${naturalCustomer.telephone}\n" +
                    "   > SSN : ${naturalCustomer.ssn}\n\n" +
                    "   Data operation  \n\n" +
                    "   > Operation code : ${UUID.randomUUID()}\n" +
                    "   > Data and time : ${currentTime}")
        }
    }
}