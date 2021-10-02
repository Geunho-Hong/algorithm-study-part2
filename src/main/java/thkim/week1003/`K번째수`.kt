package thkim.week1003

fun main() {
    val answer = `K번째수`().solution(
        intArrayOf(1, 5, 2, 6, 3, 7, 4),
        arrayOf(
            intArrayOf(2, 5, 3),
            intArrayOf(4, 4, 1),
            intArrayOf(1, 7, 3)
        )
    )

    answer.forEach { print("$it ") }
    println()

}

class `K번째수` {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = IntArray(commands.size)

        commands.forEachIndexed { index, arr ->
            val i = arr[0]
            val j = arr[1]
            val k = arr[2]
            val sliceArr = array.slice((i - 1) until j).toIntArray()
            sort(sliceArr, 0, sliceArr.size - 1)
            answer[index] = sliceArr[k - 1]
        }

        return answer
    }

    fun sort(a: IntArray, left: Int, right: Int) {
        var pl = left
        var pr = right
        val x = a[(pl + pr) / 2]
        do {
            while (a[pl] < x) pl++
            while (a[pr] > x) pr--
            if (pl <= pr) {
                val temp = a[pl]
                a[pl] = a[pr]
                a[pr] = temp
                pl++
                pr--
            }
        } while (pl <= pr)
        if (left < pr) sort(a, left, pr)
        if (right > pl) sort(a, pl, right)
    }
}