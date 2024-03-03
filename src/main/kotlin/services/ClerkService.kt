package services

import application.main
import entities.persons.Clerk
import services.ClerkRequestsService.Companion.analiseUpdateIncome
import services.ClerkRequestsService.Companion.doAccountCreation
import services.ClerkRequestsService.Companion.doAccountDeletion
import services.ClerkRequestsService.Companion.doAccountDisabilitation
import utilities.Util.Companion.printMessage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class ClerkService {
    companion object{
        fun doLoginClerk(){
            var clerks : MutableList<Clerk> = ArrayList<Clerk>()
            val clerk1 = Clerk(2, "Needham", "need@gmail.com", "need", "20")
            val clerk2 = Clerk(3, "Doberainer", "dobe@gmail.com", "dobe", "30")
            clerks.add(clerk1)
            clerks.add(clerk2)
            var helpClerk = Clerk(1, "", "", "", "")
            var login : Boolean = false
            var attempts : Int = 3
            printMessage("      PAGE LOGIN CLERK        \n")
            println("Enter your username and password : ")
            do {
                println("Username : ")
                var username = readLine()
                println("Password : ")
                var password = readLine()

                for (clerk : Clerk in clerks){
                    if (clerk.username.equals(username) && clerk.password.equals(password)){
                        login = true
                        helpClerk = clerk
                        break
                    }
                }
                if (login){
                    println("Login successfully!\n")
                    interactesClerk(helpClerk)
                }
                else{
                    println("Credentials not recognized.\n")
                    attempts--
                }
            } while (attempts > 0)

        }
        fun interactesClerk(clerk : Clerk){
            printMessage("      Welcome to your page, dearest ${clerk.nameClerk}\n")
            println("            Choose an option            \n\n" +
                    "                       CUSTOMER REQUESTS\n\n" +
                    "                       1 - Create account of customers\n" +
                    "                       2 - Delete account of customers\n" +
                    "                       3 - Disable account of customers\n" +
                    "                       4 - Working with income change requests\n\n" +
                    "                       PERSONAL DATA\n\n" +
                    "                       5 - Query data\n" +
                    "                       6 - Update data\n\n" +
                    "                       SYSTEM OPERATIONS\n\n" +
                    "                       7 - Return to the initial menu\n")
            var option = readLine()?.toIntOrNull()

            when(option){
                1 -> {
                    doAccountCreation()
                }
                2 -> {
                    doAccountDeletion()
                }
                3 -> {
                    doAccountDisabilitation()
                }
                4 -> {
                    analiseUpdateIncome()
                }
                5 -> {
                    queryDataClerk(clerk);
                }
                6 -> {
                    updateDataClerk(clerk)
                }
                7 -> {
                    main()
                }
            }
        }
        fun queryDataClerk(clerk : Clerk) : Boolean {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            val currentTime= LocalDateTime.now().format(formatter)
            printMessage("QUERY DATA" +
                    "    > Name : ${clerk.nameClerk}\n" +
                    "    > Id of clerk : ${clerk.idClerk}\n" +
                    "    > Email : ${clerk.emailClerk}\n" +
                    "    > Username : ${clerk.username}\n\n" +
                    "     OPERATION DATA\n\n" +
                    "    > Code operation : ${UUID.randomUUID()}\n" +
                    "    > Date and time : ${currentTime}\n")
            return true
        }
        fun updateDataClerk(clerk: Clerk): Boolean {
            printMessage("You have permission to update only email, username and password.\n")
            println(" E/e - Email \n U/u - Username\n P/p - Password\n")
            var option = readLine()?.trim()?.lowercase(Locale.getDefault())

            when(option){
                "e" -> {
                    println("New email : ")
                    var newEmail = readLine()
                    if (newEmail != null) {
                        clerk.emailClerk = newEmail
                        println("Email updated successfully!")
                    }
                    else{
                        println("Operation unsuccessuflly!\n")
                    }
                }
                "u" -> {
                    println("New username : ")
                    var newUsername = readLine()
                    if (newUsername != null) {
                        clerk.username = newUsername
                        println("Username updated successfully!")
                    }
                    else{
                        println("Operation unsuccessuflly!\n")
                    }
                }
                "p" -> {
                    println("New password : ")
                    var newPassword = readLine()
                    if (newPassword != null) {
                        clerk.password = newPassword
                        println("Password updated successfully!")
                    }
                    else{
                        println("Operation unsuccessuflly!\n")
                    }
                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                    return false
                }
            }
            return true
        }
    }
}