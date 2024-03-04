package services

import entities.persons.Clerk
import entities.persons.Customer
import repositories.Financial
import utilities.Util.Companion.printMessage
import utilities.Util.Companion.sc

class FinancialService : Financial {
    companion object{
        fun driveFinancialOperations(){
            printMessage("FINANCIAL OPERATIONS\n")
            println("Choose the operation : \n" +
                    "1 - Deposit money : \n" +
                    "2 - Debit money : \n" +
                    "3 - Do transference : \n")
            var option = sc.nextInt()

            when(option){
                1 -> {
                    doDepositMoney()
                }
                2 -> {
                    doDebitMoney()
                }
                3 -> {
                    doTransferMoney()
                }
                else -> {
                    printMessage("Sorry, however this option´s no existent.\n")
                }
            }
        }
        fun validCustomer() : Customer? {
            println("Enter id person : ")
            var id = sc.nextInt()

            val customer = CustomerService.naturals.find { it.idCustomer == id } ?: CustomerService.legals.find { it.idCustomer == id }

            if (customer != null){
                println("Enter number account : ")
                var numberAccount = sc.nextInt()

                val account = ClerkRequestsService.checkingsAccounts.find {it.accountNumber == numberAccount} ?: ClerkRequestsService.savingsAccounts.find {it.accountNumber == numberAccount}

                if (numberAccount != null){
                    return customer
                }
                else{
                    return null
                }
            }
            return customer
        }
        fun doDepositMoney() : Double{
            var value : Double = 0.0
            println("Enter number account : ")
            var numberAccount = sc.nextInt()

            val account = ClerkRequestsService.checkingsAccounts.find {it.accountNumber == numberAccount} ?: ClerkRequestsService.savingsAccounts.find {it.accountNumber == numberAccount}

            if (account != null){
                println("Enter value deposit : ")
                value = sc.nextDouble()

                account.balance += value
            }
            else{
                printMessage("Account not found.\n")
            }
            return value
        }
        fun doDebitMoney() : Double {
            var value : Double = 0.0
            println("Enter number account : ")
            var numberAccount = sc.nextInt()

            val account = ClerkRequestsService.checkingsAccounts.find {it.accountNumber == numberAccount} ?: ClerkRequestsService.savingsAccounts.find {it.accountNumber == numberAccount}

            if (account != null){
                println("Enter value deposit : ")
                value = sc.nextDouble()

                if (account.balance - value >= 0){
                    account.balance -= value
                }
                else{
                    printMessage("Insufficient balance to carry out a debit transaction.\n")
                }
            }
            else{
                printMessage("Account not found.\n")
            }
            return value
        }
        fun doTransferMoney() : Double{
            var value : Double = 0.0
            println("Enter number account : ")
            var numberAccount = sc.nextInt()

            val account = ClerkRequestsService.checkingsAccounts.find {it.accountNumber == numberAccount} ?: ClerkRequestsService.savingsAccounts.find {it.accountNumber == numberAccount}

            if (account != null) {
                val customer = validCustomer()
                if (customer != null) {
                    println("Enter value to transfer for customer : ${customer.nameCustomer}, ${customer.idCustomer}: ")
                    value = sc.nextDouble()

                    if (account.balance - value >= 0.0){
                        account.balance -= value
                        customer.accounts?.find { it.accountNumber == numberAccount }?.balance?.plus(value)
                            ?: run {
                                printMessage("Account not found for this customer.\n")
                            }
                    }
                    else{
                        printMessage("Insufficient balance to carry out a debit transaction.\n")
                    }
                }
            }
            else{
                printMessage("Account not found.\n")
            }
            return value
        }
    }
}