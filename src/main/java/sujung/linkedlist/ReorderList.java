package sujung.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public void reorderList(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();

        ListNode pointer = head.next;

        while (pointer != null) {
            dq.offer(pointer);
            pointer = pointer.next;
        }

        boolean flag = true;
        if (!dq.isEmpty()) {
            if (flag) {
                head.next = dq.pollLast();
                head = head.next;
                flag = false;
            } else {
                head.next = dq.pollFirst();
                head = head.next;
                flag = true;
            }
        }
        head.next = null;
    }
}
