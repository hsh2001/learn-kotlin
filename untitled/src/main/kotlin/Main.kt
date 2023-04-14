import java.util.*

// https://www.acmicpc.net/problem/1920

fun main(): Unit = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()
    val an = stringToIntArray(nextLine(), n)
    val m = nextLine().toInt()
    val bn = stringToIntArray(nextLine(), m)

    an.sort()

//    var result = ""

    for (i in 0 until m) {
        if (containsWithBinary(an, bn[i], 0, n - 1)) {
//            result += "1\n"
            println("1")
        } else {
//            result += "0\n"
            println("0")
        }
    }

//    print(result)
}

fun stringToIntArray(string:String, size: Int): IntArray {
    val raw = string.trim().split(' ').map { it.toInt(); }
    val result = IntArray(size)

    for (i in 0 until size) {
        result[i] = raw[i]
    }

    return result
}

fun containsWithBinary(intArray: IntArray, target: Int, start: Int, end: Int): Boolean {
    if (start > end) return false

    val mid = (start + end) / 2

    if (intArray[mid] == target) {
        return true
    } else if (intArray[mid] > target) {
        return containsWithBinary(intArray,target, start, mid - 1);
    } else {
        return containsWithBinary(intArray,target, mid + 1, end);
    }
}

