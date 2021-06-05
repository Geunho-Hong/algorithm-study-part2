package min.stack;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public static int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> input = new ArrayList<>();
        while (Objects.nonNull(head)) {
            input.add(head.val);
            head = head.next;
        }

        int[] inputs = input.stream().mapToInt(v -> v).toArray();
        int[] outputs = new int[inputs.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < inputs.length; i++) {
            while (!st.isEmpty() && inputs[st.peek()] < inputs[i]) {
                outputs[st.pop()] = inputs[i];
            }
            st.push(i);
        }

        return outputs;
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