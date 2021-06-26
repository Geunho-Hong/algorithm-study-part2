package thkim.linkedlist

class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        var slowNode = head
        var fastNode = head

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next!!.next
            slowNode = slowNode!!.next
            if (slowNode == fastNode) return true
        }

        return false
    }
}