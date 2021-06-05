package min.stack;

import org.junit.jupiter.api.Test;

import static min.stack.NextGreaterNodeInLinkedList.ListNode;
import static min.stack.NextGreaterNodeInLinkedList.nextLargerNodes;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextGreaterNodeInLinkedListTest {

    @Test
    void test_1() {
        // given
        ListNode node3 = new ListNode(5);
        ListNode node2 = new ListNode(1, node3);
        ListNode head = new ListNode(2, node2);

        // when
        int[] res = nextLargerNodes(head);

        // then
        assertArrayEquals(new int[]{5, 5, 0}, res);
    }

    @Test
    void test_2() {
        // given
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(7, node3);
        ListNode head = new ListNode(2, node2);

        // when
        int[] res = nextLargerNodes(head);

        // then
        assertArrayEquals(new int[]{7, 0, 5, 5, 0}, res);
    }

}