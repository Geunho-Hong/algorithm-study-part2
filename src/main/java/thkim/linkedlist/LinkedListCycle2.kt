package thkim.linkedlist

class LinkedListCycle2 {
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next

            if (fast == slow) {
                var slow2 = head

                while (slow2 != slow) {
                    slow = slow!!.next
                    slow2 = slow2!!.next
                }

                return slow
            }
        }

        return null
    }
}