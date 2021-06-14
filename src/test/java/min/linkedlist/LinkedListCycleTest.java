package min.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static min.linkedlist.LinkedListCycle.*;

class LinkedListCycleTest {

    @Test
    void test_case_1() {
        // given
        var n3 = new ListNode(-4, null);
        var n2 = new ListNode(0, n3);
        var n1 = new ListNode(2, n2);
        var head = new ListNode(3, n1);

        // when
        boolean res = hasCycle(head);

        // then
        Assertions.assertThat(res).isFalse();
    }

}