package challenges.hotel

import java.time.LocalDate

class Hotel(
    private val name: String,
    private val rooms: MutableIterable<Room>,
    private val reservations: MutableList<Reservation> = mutableListOf()
) {
    fun makeReservation(guest: Guest, roomNumber: Int, checkIn: LocalDate, checkOut: LocalDate): Reservation {
        val room: Room = findRoomByNumber(roomNumber) ?: throw IllegalArgumentException("Room $roomNumber does not exist")

        if (!isAvailableAt(room, checkIn, checkOut)) throw java.lang.IllegalArgumentException("Room $roomNumber is not available to reserve from $checkIn to $checkOut.")

        val reservation = Reservation(checkIn, checkOut, guest, room)
        reservations.add(reservation)
        return reservation
    }

    private fun isAvailableAt(room: Room, checkIn: LocalDate, checkOut: LocalDate): Boolean {
        return reservations.none {
            it.isReservedAt(checkIn, room) || it.isReservedAt(checkOut.minusDays(1), room)
        }
    }

    fun cancelReservation(reservationId: String): Reservation {
        val reservation = reservations.find { it.getReservationId() == reservationId } ?: throw IllegalArgumentException("Reservation with the id: $reservationId does not exist")
        reservations.remove(reservation)
        return reservation
    }

    fun getRoomsAvailable(date: LocalDate): List<Room> {
        return rooms.filter { isAvailableAt(it, date, date.plusDays(1)) }
    }

    private fun findRoomByNumber(roomNumber: Int): Room? {
        return rooms.find { it.number == roomNumber }
    }
}