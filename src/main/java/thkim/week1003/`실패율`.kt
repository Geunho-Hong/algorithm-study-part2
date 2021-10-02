package thkim.week1003

fun main() {
    val answer = `실패율`().solution(
        5,
        intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)
    )

    answer.forEach {
        print("$it ")
    }
    println()

    val answer2 = `실패율`().solution(
        4,
        intArrayOf(4, 4, 4, 4, 4)
    )

    answer2.forEach {
        print("$it ")
    }
    println()

    val answer3 = `실패율`().solution(
        5,
        intArrayOf(6, 6, 6, 6, 5)
    )

    answer3.forEach {
        print("$it ")
    }
}

class `실패율` {
    fun solution(N: Int, stages: IntArray): IntArray {
        val stayingStages = IntArray(N + 2)
        val reachedStages = IntArray(N + 2)
        val failRates = ArrayList<Pair<Int, Double>>()

        stages.forEach {
            stayingStages[it]++
            for (i in 1..it) reachedStages[i] += 1
        }

        for (i in 1 until N + 1) {
            if (reachedStages[i] == 0) failRates.add(i to 0.0)
            else failRates.add(i to stayingStages[i] / reachedStages[i].toDouble())
        }

        failRates.sortWith(object : Comparator<Pair<Int, Double>> {
            override fun compare(o1: Pair<Int, Double>, o2: Pair<Int, Double>): Int {
                return if (o1.second - o2.second > 0) {
                    -1
                } else if (o1.second - o2.second == 0.0) {
                    o1.first - o2.first
                } else {
                    1
                }
            }
        })

//        failRates.sortWith { o1, o2 ->
//            if (o1.second - o2.second > 0) {
//                return@sortWith -1
//            } else if (o1.second - o2.second == 0.0) {
//                return@sortWith o1.first - o2.first
//            } else {
//                return@sortWith 1
//            }
//        }

        return failRates.map { it.first }.toIntArray()
    }

}