package services

import utilities.Util.Companion.printMessage
import java.util.*

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

                }
                "n" -> {

                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
        }
    }
}