package entities.bank

import java.sql.Time
import java.util.*

data class Movement(
    val idMovement : UUID,
    val dateMovement : Date,
    val timeMovement : Time,
    var valueMovement : Double
    )