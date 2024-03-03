package services

import entities.bank.CheckingAccount
import entities.bank.Request
import entities.bank.SavingsAccount
import enumerations.TypeAccountCreation
import enumerations.TypeRequest
import repositories.GenerationId.Companion.generateIdCheckingAccount
import repositories.GenerationId.Companion.generateIdSavingsAccount
import services.LegalCustomerService.Companion.legalRequests
import services.NaturalCustomerService.Companion.naturalRequests
import utilities.Util.Companion.printMessage
import utilities.Util.Companion.sc
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ClerkRequestsService {
    companion object{
        public var checkingsAccounts : MutableList<CheckingAccount> = ArrayList<CheckingAccount>()
        public var savingsAccounts : MutableList<SavingsAccount> = ArrayList<SavingsAccount>()

        fun doAccountCreation() : Boolean{
            printMessage("Perform the operation by client id.")
            if (!legalRequests.isEmpty() && !naturalRequests.isEmpty()){
                for (legal in legalRequests){
                    if (legal.typeRequest == TypeRequest.CREATION){
                        printMessage("Request code : ${legal.idRequest}\n" +
                                "     Customer id : ${legal.customer.idCustomer}\n" +
                                "     Customer name : ${legal.customer.nameCustomer}\n" +
                                "     Type request : ${legal.typeRequest}\n" +
                                "     Type customer : ${legal.typeCustomer}\n" +
                                "     Type account disabilitation : ${legal.typeAccountCreation}")
                    }
                }
                for (natural in naturalRequests){
                    if (natural.typeRequest == TypeRequest.CREATION){
                        printMessage("Request code : ${natural.idRequest}\n" +
                                "     Customer id : ${natural.customer.idCustomer}\n" +
                                "     Customer name : ${natural.customer.nameCustomer}\n" +
                                "     Type request : ${natural.typeRequest}\n" +
                                "     Type customer : ${natural.typeCustomer}\n" +
                                "     Type account disabilitation : ${natural.typeAccountCreation}")
                    }
                }
                println("Enter id :")
                var id = sc.nextInt()

                val customer = naturalRequests.find { it.customer.idCustomer == id } ?: legalRequests.find { it.customer.idCustomer == id }

                if (customer != null){
                    println("Account creation successfully!\n")
                }
                else{
                    println("Operation unsuccessfully!\n")
                }
            }
            else {
                println("Have no account requests creations.\n")
                return false
            }
            return true
        }
        fun doAccountDeletion() : Boolean{
            printMessage("Perform the operation by client id.")
            if (!legalRequests.isEmpty() && !naturalRequests.isEmpty()){
                for (legal in legalRequests){
                    if (legal.typeRequest == TypeRequest.DELETION){
                        printMessage("Request code : ${legal.idRequest}\n" +
                                "     Customer id : ${legal.customer.idCustomer}\n" +
                                "     Customer name : ${legal.customer.nameCustomer}\n" +
                                "     Type request : ${legal.typeRequest}\n" +
                                "     Type customer : ${legal.typeCustomer}\n" +
                                "     Type account disabilitation : ${legal.typeAccountCreation}")
                    }
                }
                for (natural in naturalRequests){
                    if (natural.typeRequest == TypeRequest.DELETION){
                        printMessage("Request code : ${natural.idRequest}\n" +
                                "     Customer id : ${natural.customer.idCustomer}\n" +
                                "     Customer name : ${natural.customer.nameCustomer}\n" +
                                "     Type request : ${natural.typeRequest}\n" +
                                "     Type customer : ${natural.typeCustomer}\n" +
                                "     Type account disabilitation : ${natural.typeAccountCreation}")

                    }
                }
                println("Enter id :")
                var id = sc.nextInt()

                val customer = naturalRequests.find { it.customer.idCustomer == id } ?: legalRequests.find { it.customer.idCustomer == id }

                if (customer != null){
                    println("Account deletion successfully!\n")
                }
                else{
                    println("Operation unsuccessfully!\n")
                }
            }
            else {
                println("Have no account requests deletions.\n")
                return false
            }
            return true
        }
        fun doAccountDisabilitation() : Boolean {
            printMessage("Perform the operation by client id.")
            if (!legalRequests.isEmpty() && !naturalRequests.isEmpty()){
                for (legal in legalRequests){
                    if (legal.typeRequest == TypeRequest.DISABILITATION){
                        printMessage("Request code : ${legal.idRequest}\n" +
                                "     Customer id : ${legal.customer.idCustomer}\n" +
                                "     Customer name : ${legal.customer.nameCustomer}\n" +
                                "     Type request : ${legal.typeRequest}\n" +
                                "     Type customer : ${legal.typeCustomer}\n" +
                                "     Type account disabilitation : ${legal.typeAccountCreation}")
                    }
                }
                for (natural in naturalRequests){
                    if (natural.typeRequest == TypeRequest.DISABILITATION){
                        printMessage("Request code : ${natural.idRequest}\n" +
                                "     Customer id : ${natural.customer.idCustomer}\n" +
                                "     Customer name : ${natural.customer.nameCustomer}\n" +
                                "     Type request : ${natural.typeRequest}\n" +
                                "     Type customer : ${natural.typeCustomer}\n" +
                                "     Type account disabilitation : ${natural.typeAccountCreation}")
                    }
                }
                println("Enter id :")
                var id = sc.nextInt()

                val customer = naturalRequests.find { it.customer.idCustomer == id } ?: legalRequests.find { it.customer.idCustomer == id }

                if (customer != null){
                    println("Account disabilitation successfully!\n")
                }
                else{
                    println("Operation unsuccessfully!\n")
                }
            }
            else {
                println("Have no account requests disabilitations.\n")
                return false
            }
            return true
        }
        fun analiseUpdateIncome(){
            printMessage("Perform the operation by client id.")

        }

        fun doCreation(request : Request) {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            val currentTime = LocalDateTime.now().format(formatter)

            if (request.typeAccountCreation == TypeAccountCreation.CHECKING) {
                var numberAccount = generateIdCheckingAccount(checkingsAccounts)
                println("Password to operations : ")
                var password = sc.nextLine()

                var balance = 0.00
                var limitAccount = 100000.00

                val checkingAccount = CheckingAccount(numberAccount, currentTime, null, password, balance, null, limitAccount)
                checkingsAccounts.add(checkingAccount)
            }
            else if (request.typeAccountCreation == TypeAccountCreation.SAVINGS) {

                var numberAccount = generateIdSavingsAccount(savingsAccounts)

                println("Password to operations : ")
                var password = sc.nextLine()

                var balance = 0.00
                var birthday = currentTime
                var yield = 0.05

                val savingAccount = SavingsAccount(numberAccount, currentTime, null, password, balance, null, birthday, yield)
                savingsAccounts.add(savingAccount)
            }
        }
        fun doDeletion(){

        }
        fun doDisabilitation(){

        }
    }
}