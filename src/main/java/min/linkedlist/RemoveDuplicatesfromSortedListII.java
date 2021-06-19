package min.linkedlist;

public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        ListNode ln4_1 = new ListNode(3, null);
        ListNode ln3_2 = new ListNode(2, ln4_1);
        ListNode ln3_1 = new ListNode(1, ln3_2);
        ListNode ln2 = new ListNode(1, ln3_1);
        ListNode ln1 = new ListNode(1, ln2);

        ListNode listNode = deleteDuplicates(ln1);
        System.out.println("listNode = " + listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode C = new ListNode(0, head);
        ListNode A = head;

        while (A != null && A.next != null) {
            if (A.val != A.next.val) {
                C = A;
                A = A.next;
            } else {
                while (A.next != null && A.val == A.next.val) {
                    if (A == head) head = A.next;
                    A = A.next;
                }
                if (A == head) head = A.next;
                A = A.next;
                C.next = A;
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
