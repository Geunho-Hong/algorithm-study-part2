package min.linkedlist;

public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        ListNode ln5 = new ListNode(5);
        ListNode ln4_2 = new ListNode(4, ln5);
        ListNode ln4_1 = new ListNode(4, ln4_2);
        ListNode ln3_2 = new ListNode(3, ln4_1);
        ListNode ln3_1 = new ListNode(3, ln3_2);
        ListNode ln2 = new ListNode(2, ln3_1);
        ListNode ln1 = new ListNode(1, ln2);

        ListNode listNode = deleteDuplicates(ln1);
        System.out.println("listNode = " + listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode connect = new ListNode(0);
        ListNode front = head;
        ListNode back = head.next;

        connect.next = front;

        while (back != null && back.next != null) {
            if (front.val == back.val) {
                front = front.next.next;
                back = back.next.next;
                connect.next = front;
            } else {
                connect = front;
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
