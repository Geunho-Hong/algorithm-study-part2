package min.linkedlist;

public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return head;

        ListNode front = head;
        ListNode back = head.next;

        while (back != null) {
            if (front.val == back.val) {
                back = back.next;
                front.next = back;
            } else {
                front = front.next;
                back = back.next;
            }
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}