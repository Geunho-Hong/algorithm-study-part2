package thkim.week1003

fun main() {
    val answer1 = `여행경로`().solution( // 	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
        arrayOf(
            arrayOf("ICN", "SFO"),
            arrayOf("ICN", "ATL"),
            arrayOf("SFO", "ATL"),
            arrayOf("ATL", "ICN"),
            arrayOf("ATL", "SFO")
        )
    )

    answer1.forEach { print("$it ") }
    println()

    val answer2 = `여행경로`().solution( // ["ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"]
        arrayOf(
            arrayOf("ICN", "AOO"),
            arrayOf("AOO", "BOO"),
            arrayOf("BOO", "COO"),
            arrayOf("COO", "DOO"),
            arrayOf("DOO", "EOO"),
            arrayOf("EOO", "DOO"),
            arrayOf("DOO", "COO"),
            arrayOf("COO", "BOO"),
            arrayOf("BOO", "AOO")
        )
    )

    answer2.forEach { print("$it ") }
    println()
}

class `여행경로` {

    fun solution(tickets: Array<Array<String>>): Array<String> {
        val visited = BooleanArray(tickets.size)
        val route = ArrayList<String>()

        fun dfs(
            count: Int = 0,
            preDestination: String = "ICN",
            list: String = "ICN"
        ) {
            if (count == tickets.size) {
                route.add(list)
                return
            }

            for (i in tickets.indices) {
                if (visited[i]) continue
                if (tickets[i][0] == preDestination) {
                    visited[i] = true
                    dfs(count + 1, tickets[i][1], "$list ${tickets[i][1]}")
                    visited[i] = false
                }
            }

            return
        }

        dfs()

        return route.sorted()[0].split(' ').toTypedArray()
    }

}
