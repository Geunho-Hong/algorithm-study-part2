package min.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            set.add(head);
            if (set.contains(head.next)) return true;
            head = head.next;
        }

        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }
}
