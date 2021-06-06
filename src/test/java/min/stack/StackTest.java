package min.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Spliterator;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StackTest {

    Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    @DisplayName("1. Stack 은 초기화 시 내부적으로 10 크기(capacity)의 배열을 생성하고, 요소의 개수는 당연히 0(size)이다.")
    void init_size_test() {
        // when
        int capacity = stack.capacity();
        int size = stack.size();

        // then
        assertThat(capacity).isEqualTo(10);
        assertThat(size).isZero();
    }

    @Test
    @DisplayName("2. Stack 에 요소가 없는데 pop 하거나 peek 할 경우 예외가 발생한다.")
    void empty_stack_pop_and_peek_test() {
        // when then
        assertThatThrownBy(stack::peek)
                .isInstanceOf(EmptyStackException.class);

        assertThatThrownBy(stack::pop)
                .isInstanceOf(EmptyStackException.class);
    }

    @Test
    @DisplayName("3. empty() 와 isEmpty() 의 차이점?")
    void difference_between_empty_and_isEmpty() {
        // when
        boolean empty = stack.empty();
        boolean isEmpty = stack.isEmpty();

        // then
        assertThat(empty).isEqualTo(isEmpty);

        /*
        - empty() 와 isEmpty() 메서드는 같은 기능을 하지만 개인적으로 Collection Framework 에서 제공하는 isEmpty() 를 쓰는게 적절해보임.

        참조
        - https://stackoverflow.com/questions/24986945/empty-vs-isempty-in-java-stack-class
         */
    }

    @Test
    @DisplayName("4. push 는 삽입한 값을 반환하고 add 는 true 를 반환한다.")
    void difference_return_value_of_push_and_add() {
        // when
        Integer push = stack.push(1);
        boolean isAdd = stack.add(2);

        // -> Index 를 지정해서 값을 삽입할 수 있지만 Stack 의 특성에 맞지 않으므로 사용하지 않는게 좋아보임.
        stack.add(1, 5);

        // then
        assertThat(push).isEqualTo(1);
        assertThat(isAdd).isTrue();
    }

    @Test
    @DisplayName("5. search 는 해당 값이 스택의 TOP 으로부터 위치를 반환한다.")
    void test() {
        // given
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // when
        int position_4 = stack.search(4);
        int position_3 = stack.search(3);
        int position_2 = stack.search(2);
        int position_1 = stack.search(1);

        // then
        assertThat(position_4).isEqualTo(1);
        assertThat(position_3).isEqualTo(2);
        assertThat(position_2).isEqualTo(3);
        assertThat(position_1).isEqualTo(4);
    }

}
