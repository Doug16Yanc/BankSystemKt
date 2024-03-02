package services

import entities.persons.LegalCustomer
import entities.persons.NaturalCustomer
import repositories.GenerationId
import utilities.Util.Companion.printMessage
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
           var legals : MutableMap<Int, LegalCustomer> = HashMap<Int, LegalCustomer>()

           var id = GenerationId.generateId(legals)
           println("Name : ")
           var name = readLine()
           println("Zip code : ")
           var zipCode = readLine()
           println("Telephone : ")
           var telephone = readLine()
           println("Email : ")
           var email = readLine()
           println("Income : ")
           var income = readLine()?.toDoubleOrNull()
           readLine()
           println("Username : ")
           var username = readLine()
           println("Password : ")
           var password = readLine()

        }
        fun recordCustomerNatural() {
            var naturals : MutableMap<Int, NaturalCustomer>
        }
    }
}