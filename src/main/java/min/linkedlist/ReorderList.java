package min.linkedlist;

public class ReorderList {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        reorderList(node1);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Reverse 할 기준 노드인 중간 노드 탐색
        var slow = head;
        var fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var middle = slow.next;
        slow.next = null;

        // 중간 노드 기준으로 List Reverse
        ListNode reverseHead = reverse(middle);

        // List 와 Reverse List 결합
        var p1 = head;
        var p2 = reverseHead;
        while (true) {
            var temp1 = p1.next;
            p1.next = p2;

            if (temp1 == null) break;

            var temp2 = p2.next;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }

    static ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }

        ListNode head = reverse(node.next);

        var temp = node.next;
        node.next = null;
        temp.next = node;

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
