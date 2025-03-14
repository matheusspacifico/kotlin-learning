package challenges.hotel

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class Reservation(
    private val checkin: LocalDate,
    private val checkout: LocalDate,
    private val guest: Guest,
    private val room: Room,
    private val id: String = ReservationIdGenerator.generateId()
) {
    private fun getPrice(): Double {
        val days: Int = Period.between(checkin, checkout).days
        return if (days == 0) room.price else room.price * days
    }

    fun isReservedAt(date: LocalDate, room: Room): Boolean {
        return date.isAfter(checkin.minusDays(1)) && date.isBefore(checkout) && this.room == room
    }

    fun asString(): String {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val sb: StringBuilder = StringBuilder()

        sb.append("_______________________________________________________________________________")
        sb.append("Reservation: ").append(id).append("\t")
        sb.append("Room number: ").append(room.number).append("\n")
        sb.append("Guest name: ").append(guest.name).append("\t")
        sb.append("SSN: ").append(guest.ssn).append("\t")
        sb.append("E-mail: ").append(guest.email).append("\n")
        sb.append("Check-in: ").append(checkin.format(formatter)).append("\t")
        sb.append("Check-out: ").append(checkout.format(formatter)).append("\n")
        sb.append("Number of days: ").append(Period.between(checkin, checkout).days).append("\t")
        sb.append("Room price: U$").append(String.format("%.1f", room.price)).append("\n")
        sb.append("TOTAL: U$").append(String.format("%.1f", getPrice())).append(";\n")
        sb.append("_______________________________________________________________________________")

        return sb.toString()
    }
}