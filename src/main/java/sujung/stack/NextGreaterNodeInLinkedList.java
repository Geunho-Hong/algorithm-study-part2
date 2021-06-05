package sujung.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] answer = new int[size];
        Deque<Node> stack = new ArrayDeque<>();

        int index = 0;
        while (head != null) {
            while (!stack.isEmpty() && stack.peek().value < head.val) {
                answer[stack.pop().index] = head.val;
            }
            stack.push(new Node(index, head.val));
            index++;
            head = head.next;
        }
        return answer;
    }

    private static class Node {
        private int index;
        private int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    /**
     * Data structure given in the problem
     */
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
}
