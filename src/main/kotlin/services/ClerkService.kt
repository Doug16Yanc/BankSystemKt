package services

import entities.persons.Clerk
import utilities.Util.Companion.printMessage

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
        }
    }
}