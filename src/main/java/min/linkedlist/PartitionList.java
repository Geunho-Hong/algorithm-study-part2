package min.linkedlist;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        var beforeHead = new ListNode(0);
        var before = beforeHead;
        var afterHead = new ListNode(0);
        var after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;

        before.next = afterHead.next;
        return beforeHead.next;
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