package min.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static min.queue.DesignCircularQueue.MyCircularQueue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DesignCircularQueueTest {

    @Test
    void test() {
        // given
        int k = 2;
        MyCircularQueue queue = new MyCircularQueue(k);

        // when
        boolean enQueue1 = queue.enQueue(1);
        boolean enQueue2 = queue.enQueue(2);
        System.out.println(queue);
        int front = queue.Front(); // 1
        int rear = queue.Rear(); // 2
        boolean deQueue1 = queue.deQueue();
        boolean isEmpty1 = queue.isEmpty(); // false
        boolean isFull1 = queue.isFull(); // false
        boolean deQueue2 = queue.deQueue();
        boolean isEmpty2 = queue.isEmpty(); // true

        // then
        assertThat(enQueue1).isTrue();
        assertThat(enQueue2).isTrue();
        assertThat(front).isEqualTo(1);
        assertThat(rear).isEqualTo(2);
        assertThat(deQueue1).isTrue();
        assertThat(isEmpty1).isFalse();
        assertThat(isFull1).isFalse();
        assertThat(deQueue2).isTrue();
        assertThat(isEmpty2).isTrue();
    }

}