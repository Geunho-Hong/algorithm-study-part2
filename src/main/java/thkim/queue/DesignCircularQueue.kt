package thkim.queue

class MyCircularQueue(k: Int) {

    private val buffer: Array<Int?> = arrayOfNulls(k)

    private var frontPos = 0 // 현재 값을 가리키고 있음
    private var rearPos = 0 // 다음 값을 가리키고 있음
    private var len = 0

    fun enQueue(value: Int): Boolean {
        if (buffer[rearPos] != null) return false

        buffer[rearPos] = value

        rearPos = (rearPos + 1) % buffer.size

        len++

        return true
    }

    fun deQueue(): Boolean {
        if (buffer[frontPos] == null || buffer.isEmpty()) return false

        buffer[frontPos] = null

        frontPos = (frontPos + 1) % buffer.size

        len--

        return true
    }

    fun Front(): Int = buffer[frontPos] ?: -1

    fun Rear(): Int = buffer[curRearPos()] ?: -1

    fun isEmpty(): Boolean = len == 0

    fun isFull(): Boolean = len == buffer.size

    fun curRearPos(): Int = if (rearPos - 1 < 0) buffer.size - 1 else rearPos - 1
}