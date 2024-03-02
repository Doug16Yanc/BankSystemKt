package services

import entities.persons.LegalCustomer
import entities.persons.NaturalCustomer
import repositories.GenerationId
import utilities.Util.Companion.printMessage
import utilities.Util.Companion.sc
import java.util.*
import kotlin.collections.HashMap

class CustomerService {
    companion object {

        fun asksAboutCustomer() {
            var legals: MutableMap<Int, LegalCustomer> = HashMap<Int, LegalCustomer>()
            var naturals : MutableMap<Int, NaturalCustomer> = HashMap<Int, NaturalCustomer>()

            printMessage("Welcome to our page of customers\n")
            println("Have you already registered in our system?\n   Y/y - Yes\n  N/n - Not\n")
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
        fun doLoginCustomer(legals: MutableMap<Int, LegalCustomer>, naturals: MutableMap<Int, NaturalCustomer>) {
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

        fun doLoginLegal(legals: MutableMap<Int, LegalCustomer>) {
            var attempts : Int = 0
            var found : Boolean = false
            printMessage("Page of login legal customer\n")

            println("Enter your id:")
            var id = sc.nextInt()

            if (legals.containsKey(id)){
                println("Enter your username and password:")
                do{
                    println("Username : ")
                    var username = readLine()
                    println("Password : ")
                    var password = readLine()

                    for (legal in legals.values){
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
        fun doLoginNatural(naturals: MutableMap<Int, NaturalCustomer>) {
            var attempts : Int = 0
            var found : Boolean = false
            printMessage("Page of login natural customer\n")

            println("Enter your id:")
            var id = sc.nextInt()

            if (naturals.containsKey(id)){
                println("Enter your username and password:")
                do{
                    println("Username : ")
                    var username = readLine()
                    println("Password : ")
                    var password = readLine()

                    for (natural in naturals.values){
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
        fun recordCustomer(legals: MutableMap<Int, LegalCustomer>, naturals: MutableMap<Int, NaturalCustomer>) {
            printMessage("Page of customer registers\n")
            println("Are you legal or natural person?\n L/l - Legal \n N/n - Natural\n")
            var option = readLine()?.trim()?.lowercase(Locale.getDefault())

            when(option){
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
       fun recordCustomerLegal(legals: MutableMap<Int, LegalCustomer>) {

           var id = GenerationId.generateId(legals)
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
           println("EIN : ")
           var ein = sc.nextLong()

           val legalCustomer = LegalCustomer(id, name, zipCode, telephone, email, income, username, password, ein)
           legals.put(id, legalCustomer)

        }
        fun recordCustomerNatural(naturals: MutableMap<Int, NaturalCustomer>) {

            var id = GenerationId.generateId(naturals)
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
            var ssn = sc.nextLong()

            val naturaCustomer = NaturalCustomer(id, name, zipCode, telephone, email, income, username, password, ssn)
            naturals.put(id, naturaCustomer)
        }
    }
}