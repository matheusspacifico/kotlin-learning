package challenges.hotel

import java.time.LocalDate

class Hotel(
    private val name: String,
    private val rooms: List<Room>
) {
    fun makeReservation(guest: Guest, roomNumber: Int, checkIn: LocalDate, checkOut: LocalDate): Reservation {
        TODO()
    }

    private fun isAvailableAt(room: Room, checkIn: LocalDate, checkOut: LocalDate): Boolean {
        TODO()
    }

    fun cancelReservation(reservationId: String): Reservation {
        TODO()
    }

    fun getRoomsAvailable(date: LocalDate): List<Room> {
        TODO()
    }
}