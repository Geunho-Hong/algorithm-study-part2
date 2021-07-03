package sujung.linkedlist;

public class RemoveDuplicatesFromSortedList {

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


    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempHead = head;
        while (tempHead != null) {
            while (tempHead.next != null && tempHead.val == tempHead.next.val) {
                tempHead.next = tempHead.next.next;
            }
            tempHead = tempHead.next;
        }
        return head;
    }
}
