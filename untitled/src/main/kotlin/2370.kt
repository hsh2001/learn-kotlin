import java.util.*
import kotlin.collections.ArrayList

// https://www.acmicpc.net/problem/2370

fun main(): Unit = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()

    val posters = Array(n) { IntArray(2) }

    for (i in 0 until n){
        val chars = nextLine().split(' ')
        posters[n][0] = chars[0].toInt()
        posters[n][1] = chars[1].toInt()
    }

    print(solve2370(posters))
}

fun solve2370(posters: Array<IntArray>): Int {


    return 0
}