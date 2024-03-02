package application

import services.ClerkService.Companion.doLoginClerk
import services.ManagerService.Companion.doLoginManager
import services.CustomerService.Companion.asksAboutCustomer
import utilities.Util.Companion.printMessage
import java.util.*

fun main() {
    printMessage("Welcome to bank!")
    println("Who are you?")
    println(
        "       M/m - Bank manager \n" +
                "       B/b - Bank clerk \n" +
                "       C/c - Customer \n" +
                "       O/o - Log out  \n"
    )
    var option = readLine()?.trim()?.lowercase(Locale.getDefault())

    when (option) {
        "m" -> {
            doLoginManager()
        }

        "b" -> {
            doLoginClerk()
        }

        "c" -> {
            asksAboutCustomer()
        }

        "o" -> {
            printMessage("See you next time.\n")
            System.exit(0)
        }

        else -> {
            printMessage("Sorry, however this option´s no existent.\n")
        }
    }

}