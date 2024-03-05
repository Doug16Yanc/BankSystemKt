package services

import entities.persons.Manager
import utilities.Util.Companion.printMessage
import utilities.Util.Companion.sc

class ManagerService {
    companion object{
        fun doLoginManager() {
            val manager = Manager(1, "Douglas Holanda", "doug", "1609")
            var attempts : Int = 3
            printMessage("  LOGIN BANK MANAGER")
            println("Enter your username and password:")

            do {
                println("Username : ")
                var username = readLine()
                println("Password : ")
                var password = readLine()

                if (manager.username.equals(username) && manager.password.equals(password)){
                    println("Login successfully!")
                    doInteractesManager(manager)
                }
                else{
                    println("Credentials not recognized.\n ")
                    attempts--
                }
            } while(attempts > 0)
        }
        fun doInteractesManager(manager: Manager){
            printMessage("      Welcome to your page, dearest ${manager.nameManager}      \n")
            println("Select an option : \n " +
                    "1 - See reports\n" +
                    "2 - See total balance\n")
            var option = sc.nextInt()

            when(option){
                1 -> {

                }
                2 -> {

                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
        }
    }
}