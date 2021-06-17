package min.linkedlist;

public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode front = head;
        ListNode back = head.next;

        while (back != null) {
            if (front.val == back.val) {
                front = back.next;
                back = back.next.next;
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
