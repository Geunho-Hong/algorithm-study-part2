package sujung.linkedlist;

public class LinkedListCycle2 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // slow pointer move 1
            fast = fast.next.next;      // fast pointer move 2
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;   // fast pointer move 1
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
