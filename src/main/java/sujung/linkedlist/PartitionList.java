package sujung.linkedlist;

public class PartitionList {
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


    public ListNode partition(ListNode head, int x) {
        ListNode firstHead = new ListNode();
        ListNode pivotHead = new ListNode();
        ListNode smaller = firstHead;
        ListNode bigger = pivotHead;

        while (head != null) {
            if (head.val >= x) {
                bigger.next = head;
                bigger = bigger.next;
            } else {
                smaller.next = head;
                smaller = smaller.next;
            }
            head = head.next;
        }

        smaller.next = pivotHead.next;
        bigger.next = null;

        return firstHead.next;
    }
}
