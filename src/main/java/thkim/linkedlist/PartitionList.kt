package thkim.linkedlist

class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var head = head

        val lessHead = ListNode(0)
        var lessLast: ListNode? = lessHead
        val greaterHead = ListNode(0)
        var greaterLast: ListNode? = greaterHead

        while (head != null) {
            if (head.`val` < x) {
                lessLast!!.next = head
                lessLast = lessLast.next
            } else {
                greaterLast!!.next = head
                greaterLast = greaterLast.next
            }

            head = head.next
        }

        greaterLast!!.next = null

        lessLast!!.next = greaterHead.next
        return lessHead.next
    }
}