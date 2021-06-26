package thkim.linkedlist

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) {
        return head
    }

    val answer = ListNode(head.`val`)
    var nextNode = head.next

    fun recursion(curNode: ListNode) {
        if (nextNode != null) {
            if (curNode.`val` == nextNode!!.`val`) {
                nextNode = nextNode!!.next

                recursion(curNode)
            } else {
                curNode.next = nextNode

                recursion(curNode.next!!)
            }
        } else {
            curNode.next = null
        }
    }
    recursion(answer)

    return answer
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}