package min.linkedlist;

import java.util.ArrayDeque;

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
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        ListNode tempHead = head;
        while (tempHead != null) {
            deque.push(tempHead);
            tempHead = tempHead.next;
        }

        ListNode currNode = deque.poll();
        int remain = 1;
        while (!deque.isEmpty()) {
            if (remain % 2 == 0) {
                currNode.next = deque.poll();
            } else {
                currNode.next = deque.pop();
            }
            currNode = currNode.next;
            remain++;

            if (deque.size() == 1) {
                deque.peek().next = null;
            }
        }
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
