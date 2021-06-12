package thkim.queue

class LargestRectangle {
    fun largestRectangle(h: Array<Int>): Long {
        val stack = ArrayDeque<Int>()
        var maxArea = 0
        var area: Int
        var i = 0

        while (i < h.size) {
            if (stack.isEmpty() || h[stack.first()] <= h[i]) {
                stack.addFirst(i++)
            } else {
                val top = stack.removeFirst()

                area = if (stack.isEmpty()) {
                    h[top] * i
                } else {
                    h[top] * (i - stack.first() - 1)
                }

                if (area > maxArea) {
                    maxArea = area
                }
            }
        }

        while (stack.isNotEmpty()) {
            val top = stack.removeFirst()

            area = if (stack.isEmpty()) {
                h[top] * i
            } else {
                h[top] * (i - stack.first() - 1)
            }

            if (area > maxArea) {
                maxArea = area
            }
        }

        return maxArea.toLong()
    }
}