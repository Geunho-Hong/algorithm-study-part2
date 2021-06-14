package min.linkedlist;

import java.util.LinkedList;

public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 55);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        return null;
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