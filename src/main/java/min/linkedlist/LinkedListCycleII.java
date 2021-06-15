package min.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            nodeSet.add(head);
            if (nodeSet.contains(head.next)) {
                return head.next;
            }
            head = head.next;
        }

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
