package services

import entities.persons.Manager
import utilities.Util.Companion.printMessage

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
        }
    }
}