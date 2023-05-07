import java.math.BigInteger
import java.util.*
import kotlin.collections.HashMap

// https://www.acmicpc.net/problem/1351

// 정수 N, P, Q에 대하여 무한 수열 A는
// A_0 = 1
// A_i = A_[i / P] + A_[i / Q]
// 주어진 입력에 대하여 A_N을 구하라.

fun main(): Unit = with(Scanner(System.`in`)) {
    val (n, p, q) = nextLine().trim().split(' ').map { it.trim().toBigInteger() }

    println(solve1351(n, p, q))
}

class Array1351(private val p: BigInteger, private val q: BigInteger) {
    private val valueCache = HashMap<BigInteger, BigInteger>()

    fun valueOf(i: BigInteger): BigInteger {
        if (i == BigInteger.valueOf(0)) return BigInteger.valueOf(1)

        if (valueCache.containsKey(i)) {
            return valueCache[i]!!
        }

        val result = this.valueOf(i.divide(this.p)) + this.valueOf(i.divide(this.q))

        valueCache[i] = result

        return result
    }
}

fun solve1351(n: BigInteger, p: BigInteger, q: BigInteger): BigInteger {
    return Array1351(p, q).valueOf(n)
}
