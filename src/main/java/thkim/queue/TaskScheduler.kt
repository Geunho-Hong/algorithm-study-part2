package thkim.queue

import java.util.*

class TaskScheduler {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val queue = PriorityQueue<Int>(Collections.reverseOrder())

        val countMap = tasks.asSequence().groupingBy { it }.eachCount()
        queue.addAll(countMap.values)

        var count = 0

        while (queue.isNotEmpty()) {
            val list = mutableListOf<Int>()

            for (i in 0 until (n + 1)) {
                if (queue.isEmpty()) break
                val data = queue.poll()
                list.add(data - 1)
            }
            queue.addAll(list.filter { it != 0 })

            count += if (queue.isNotEmpty()) {
                n + 1
            } else {
                list.size
            }
        }

        return count
    }

    fun leastInterval2(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)
        var max_eq_count = 0
        var max = 0
        for (c in tasks) {
            val task = c - 'A'
            freq[task]++
            if (max < freq[task]) {
                max = freq[task]
                max_eq_count = 1
            } else if (max == freq[task]) max_eq_count++
        }

        return Math.max(max + (max - 1) * n + max_eq_count - 1, tasks.size)
    }
}