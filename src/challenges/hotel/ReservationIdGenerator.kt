package challenges.hotel

import java.time.LocalTime

object ReservationIdGenerator {
    private var fiveZ: Int = 10000

    fun generateId(): String {
        val resId: StringBuilder = StringBuilder("HT")
        resId.append(LocalTime.now().second.toString().padStart(2, '0')).append("-")
        resId.append(LocalTime.now().minute.toString().padStart(2, '0')).append("-")
        resId.append(LocalTime.now().second.toString().padStart(2, '0')).append("-")
        resId.append(fiveZ)

        fiveZ++
        return resId.toString()
    }
}