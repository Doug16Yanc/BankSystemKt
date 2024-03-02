package repositories

import entities.persons.LegalCustomer
import kotlin.random.Random

class GenerationId {
    companion object {
        fun generateId(legals: MutableMap<Int, LegalCustomer>) : Int{
            var enter = Random.nextInt(1000, 100000)
            var help : Boolean = true
            while (enter != 1) {
                for (i in 0 until legals.size) {
                    if (legals.containsKey(enter)) {
                        help = false
                    }
                }
            }
            if (help){
                return enter
            }
            else {
                enter = Random.nextInt(1000, 100000)
            }
            return enter
        }
    }
}