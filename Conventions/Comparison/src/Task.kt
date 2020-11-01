data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            year > other.year -> 1
            year < other.year -> -1
            else -> when {
                month > other.month -> 1
                month < other.month -> -1
                else -> when {
                    dayOfMonth > other.dayOfMonth -> 1
                    dayOfMonth < other.dayOfMonth -> -1
                    else -> 0
                }
            }
        }
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
