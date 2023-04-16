import java.util.*

// https://www.acmicpc.net/problem/1802

fun main(): Unit = with(Scanner(System.`in`)) {
    val t = nextLine().toInt()
    val results = BooleanArray(t)

    for (i in 0 until t) {
        val line = nextLine()
        val inOuts = BooleanArray(line.length).toMutableList()

        for (x in line.indices) {
            inOuts[x] = line[x] == '1'
        }

        results[i] = isReFoldable(inOuts)
    }

    print(results.joinToString("\n") { if (it) "YES" else "NO" })
}

fun isReFoldable(inOuts: List<Boolean>): Boolean {
    if (inOuts.size == 1) return true

    val mid = inOuts.size / 2

    for (i in 0 until mid) {
        if (inOuts[i] == inOuts[inOuts.lastIndex - i]) return false
    }

    return isReFoldable(inOuts.slice(0 until mid)) && isReFoldable(inOuts.slice(mid + 1 until inOuts.size))
}