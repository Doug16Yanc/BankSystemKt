package services

import repositories.Financial

class FinancialService : Financial {
    companion object{
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