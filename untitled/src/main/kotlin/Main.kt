import java.util.*
import kotlin.math.max

// https://www.acmicpc.net/problem/17829

fun main(): Unit = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()
    val matrix = Array(n) { IntArray(n) { 0 } }

    for (i in 0 until n) {
        val row = nextLine().trim().split(' ').map { it.toInt(); }

        for (j in 0 .. row.lastIndex) {
            matrix[i][j] = row[j]
        }
    }

    print(solve(matrix).toString())
}

fun solve(matrix: Array<IntArray>): Int {
    if (matrix.size == 2) {
        val numbers = IntArray(4)

        numbers[0] = matrix[0][0]
        numbers[1] = matrix[0][1]
        numbers[2] = matrix[1][0]
        numbers[3] = matrix[1][1]

        return getSecondLargestInt(numbers)
    }

    val halfSize = matrix.size / 2
    val halfMatrix = Array(halfSize) { IntArray(halfSize) { 0 } }

    val candidateValues = IntArray(4)

    var index = 0;

    for (dx in 0 .. 1) {
        for (dy in 0 .. 1) {
            for (i in (halfSize * dx) until (halfSize * (dx + 1))) {
                for (j in (halfSize * dy) until (halfSize * (dy + 1))) {
                    halfMatrix[i - halfSize * dx][j - halfSize * dy] = matrix[i][j]
                }
            }

            candidateValues[index] = solve(halfMatrix)
            index++
        }
    }

    return getSecondLargestInt(candidateValues)
}

fun getSecondLargestInt(_numbers: IntArray): Int{
    val numbers = _numbers.clone();
    numbers.distinct()
    numbers.sort()
    return numbers[2]

}
