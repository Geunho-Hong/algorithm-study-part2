package thkim.queue

class CastleOnTheGrid {
    fun minimumMoves(grid: Array<String>, startX: Int, startY: Int, goalX: Int, goalY: Int): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addFirst(startX to startY)

        fun bfs(q: ArrayDeque<Pair<Int, Int>>): Int {
            val distance = mutableListOf<IntArray>()

            // 빈 데이터 삽입.
            grid.forEachIndexed { idx1, s ->
                val list = mutableListOf<Int>()

                for (i in s) {
                    list.add(0)
                }

                distance.add(idx1, list.toIntArray())
            }

            // 비교를 위한 초기값 설정.
            for (i in grid.indices) {
                for (j in grid[i].indices) {
                    distance[i][j] = Int.MAX_VALUE
                }
            }

            distance[startX][startY] = 0

            while (q.isNotEmpty()) {
                val de = q.removeLast()
                val curX: Int = de.first
                val curY: Int = de.second
                val curD: Int = distance[curX][curY] + 1

                // Down
                for (X in curX + 1 until grid.size) {
                    if (grid[X][curY] == 'X') {
                        break
                    }
                    if (distance[X][curY] > curD) {
                        distance[X][curY] = curD
                        q.addFirst(X to curY)
                    }
                }

                // Up
                for (X in curX - 1 downTo 0) {
                    if (grid[X][curY] == 'X') {
                        break
                    }
                    if (distance[X][curY] > curD) {
                        distance[X][curY] = curD
                        q.addFirst(X to curY)
                    }
                }

                // Right
                for (Y in curY + 1 until grid[0].length) {
                    if (grid[curX][Y] == 'X') {
                        break
                    }
                    if (distance[curX][Y] > curD) {
                        distance[curX][Y] = curD
                        q.addFirst(curX to Y)
                    }
                }

                // Left
                for (Y in curY - 1 downTo 0) {
                    if (grid[curX][Y] == 'X') {
                        break
                    }
                    if (distance[curX][Y] > curD) {
                        distance[curX][Y] = curD
                        q.addFirst(curX to Y)
                    }
                }
            }

            return distance[goalX][goalY]
        }

        return bfs(queue)
    }
}