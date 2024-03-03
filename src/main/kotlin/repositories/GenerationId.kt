package repositories

import entities.bank.CheckingAccount
import entities.bank.SavingsAccount
import entities.persons.LegalCustomer
import entities.persons.NaturalCustomer
import kotlin.random.Random

class GenerationId {
    companion object {
        fun generateIdLegal(legals: MutableList<LegalCustomer>): Int {
            var enter: Int
            var help: Boolean

            do {
                enter = Random.nextInt(1000, 100000)
                help = true
                for (i in legals) {
                    if (i.idCustomer == enter) {
                        help = false
                        break
                    }
                }
            } while (!help)

            return enter
        }

        fun generateIdNatural(naturals: MutableList<NaturalCustomer>): Int {
            var enter: Int
            var help: Boolean

            do {
                enter = Random.nextInt(1000, 100000)
                help = true
                for (i in naturals) {
                    if (i.idCustomer == enter) {
                        help = false
                        break
                    }
                }
            } while (!help)

            return enter
        }
        fun generateIdCheckingAccount(checkingAccounts: MutableList<CheckingAccount>): Int {
            var enter: Int
            var help: Boolean

            do {
                enter = Random.nextInt(8000, 800000)
                help = true
                for (i in checkingAccounts) {
                    if (i.accountNumber == enter) {
                        help = false
                        break
                    }
                }
            } while (!help)

            return enter
        }
        fun generateIdSavingsAccount(savingsAccounts: MutableList<SavingsAccount>): Int {
            var enter: Int
            var help: Boolean

            do {
                enter = Random.nextInt(8000, 800000)
                help = true
                for (i in savingsAccounts) {
                    if (i.accountNumber == enter) {
                        help = false
                        break
                    }
                }
            } while (!help)

            return enter
        }


    }
}