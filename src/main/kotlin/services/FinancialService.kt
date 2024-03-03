package services

import repositories.Financial
import utilities.Util.Companion.printMessage

class FinancialService : Financial {
    companion object{
        fun driveFinancialOperations(){
            printMessage("FINANCIAL OPERATIONS\n")
            println("")
        }
        fun doDepositMoney() : Double{
            return 1.00
        }
        fun doDebitMoney() : Double {
            return 1.00
        }
        fun doTransferMoney() : Double{
            return 1.00
        }
    }
}