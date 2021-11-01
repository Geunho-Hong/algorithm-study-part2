package seungho.stack;

import java.util.Stack;

public class Removing_them_in_pairs_programmers {
    public int solution(String s) {
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            }
        }

        return stack.size() > 0 ? 0 : 1;
    }
}
