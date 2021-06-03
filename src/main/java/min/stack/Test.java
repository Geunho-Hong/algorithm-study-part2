package min.stack;

import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new Stack<>();

        Integer push = stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        boolean add = stack.add(99);

        System.out.println("stack = " + stack);
    }
}
