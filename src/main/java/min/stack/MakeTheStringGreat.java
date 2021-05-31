package min.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class MakeTheStringGreat {

    public static void main(String[] args) {
        String result = makeGood("leEeetcode");
        System.out.println("result = " + result);
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            Character lastChar = stack.peek();
            if (!lastChar.equals(c) && Math.abs(lastChar - c) == 32) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
