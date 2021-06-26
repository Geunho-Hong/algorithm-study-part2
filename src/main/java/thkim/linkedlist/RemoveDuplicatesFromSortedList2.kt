package thkim.linkedlist

fun deleteDuplicates2(head: ListNode?): ListNode? {
    var head = head

    // head 가 마지막 값일 때.
    if (head?.next == null) return head

    return if (head.`val` != head.next!!.`val`) {
        head.next = deleteDuplicates2(head.next) // 다음 노드 결정.
        head
    } else {
        // 중복 값일 때 현재 값에 다음 값을 지정
        while (head!!.next != null && head.`val` == head.next!!.`val`) head = head.next
        deleteDuplicates2(head.next)
    }
}