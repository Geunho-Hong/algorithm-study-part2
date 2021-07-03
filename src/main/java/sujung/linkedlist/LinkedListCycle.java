package sujung.linkedlist;

public class LinkedListCycle {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        int MAX = Integer.MAX_VALUE;
        while (head != null && head.val != MAX) {
            head.val = MAX;
            head = head.next;
        }
        return head != null;
    }
}
