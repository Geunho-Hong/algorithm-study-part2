package thkim.stack

import java.util.*

class NextGreaterNode {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    fun nextLargerNodes(head: ListNode): IntArray {
        val list = arrayListOf<Int>()
        var node: ListNode? = head

        // ListNode 의 값을 arrayList 에 넣는다.
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }

        val result = IntArray(list.size)
        val stack = Stack<Int>()

        for (i in list.indices) {
            while (stack.isNotEmpty() && list[stack.peek()] < list[i]) {
                result[stack.pop()] = list[i]
            }

            // 다음 비교를 위해 index 를 쌓는다.
            stack.push(i)
        }

        return result
    }

}