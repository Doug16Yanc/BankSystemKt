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
            printMessage("Welcome to our page of customers\n")
            println("Have you already registered in our system?\n   Y/y - Yes\n  N/n - Not\n")
            var option = readLine()?.trim()?.lowercase(Locale.getDefault())

            when(option){
                "y" -> {
                    doLoginCustomer()
                }
                "n" -> {
                    recordCustomer()
                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
        }
        fun doLoginCustomer(){

        }
        fun recordCustomer(){
            printMessage("Page of customer registers\n")
            println("Are you legal or natural person?\n L/l - Legal \n N/n - Natural\n")
            var option = readLine()?.trim()?.lowercase(Locale.getDefault())

            when(option){
                "l" -> {
                    recordCustomerLegal()
                }
                "n" -> {
                    recordCustomerNatural()
                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
        }
       fun recordCustomerLegal() {
           var legals: MutableMap<Int, LegalCustomer> = HashMap<Int, LegalCustomer>()

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
        fun recordCustomerNatural() {
            var naturals : MutableMap<Int, NaturalCustomer> = HashMap<Int, NaturalCustomer>()

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