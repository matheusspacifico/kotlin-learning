package challenges.hotel

import java.time.LocalDate

fun main() {
    val room1 = Room(number = 101, price = 100.0)
    val room2 = Room(number = 102, price = 150.0)
    val room3 = Room(number = 103, price = 200.0)

    val rooms = mutableListOf(room1, room2, room3)

    val hotel = Hotel("Hotel Daora", rooms = rooms)

    val guest1 = Guest(ssn = "123-45-6789", name = "Alice Johnson", email = "alice@example.com")
    val guest2 = Guest(ssn = "987-65-4321", name = "Bob Smith", email = "bob@example.com")

    val checkInDate = LocalDate.now()
    val checkOutDate = checkInDate.plusDays(3)

    try {
        val reservation1 = hotel.makeReservation(guest1, 101, checkInDate, checkOutDate)
        println("Reserva realizada com sucesso:\n\n${reservation1.asString()}")
    } catch (e: IllegalArgumentException) {
        println("Erro ao fazer reserva: ${e.message}\n\n")
    }

    try {
        val reservation2 = hotel.makeReservation(guest2, 102, checkInDate, checkOutDate)
        println("Reserva realizada com sucesso:\n\n${reservation2.asString()}")
    } catch (e: IllegalArgumentException) {
        println("Erro ao fazer reserva: ${e.message}\n\n")
    }

    val availableRooms = hotel.getRoomsAvailable(LocalDate.now())
    println("Quartos disponíveis para hoje: ${availableRooms.map { it.number }}\n\n")
}
