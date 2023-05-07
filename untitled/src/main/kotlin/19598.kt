import java.util.*

fun main(): Unit = with(Scanner(System.`in`)) {
    val n = nextLine().trim().toInt()
    val schedules = List(n) { Schedule(0u, 0u) }
    
    for (i in 0 until n) {
        val (startAt, endsAt) = nextLine().trim().split(' ').map { it.trim().toUInt() }
        schedules[i].startsAt = startAt
        schedules[i].endsAt = endsAt
    }

    println(getMinimumRoomCount(schedules))
}

class Schedule(var startsAt: UInt, var endsAt: UInt) {
    override fun toString(): String {
        return "Schedule(%d ~ %d)".format(startsAt.toInt(), endsAt.toInt())
    }
}

fun getMinimumRoomCount(schedules: List<Schedule>): Int {
    if (schedules.size == 1) return 1

    val sortedSchedules = schedules.sortedBy { it.startsAt }
    val roomAvailableTimes = UIntArray(schedules.size) { 0u }
    val checked = BooleanArray(schedules.size) { false }
    val startTimes = sortedSchedules.map { it.startsAt } .distinct()

    for (currentTime in startTimes) {
        for (i in sortedSchedules.indices) {
            if (checked[i] || sortedSchedules[i].startsAt > currentTime) continue

            for (j in roomAvailableTimes.indices) {
                if (roomAvailableTimes[j] > currentTime) continue

                roomAvailableTimes[j] = sortedSchedules[i].endsAt
                checked[i] = true
                break
            }
        }
    }


    return roomAvailableTimes.count { it > 0u }
}

