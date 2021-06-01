package min.stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        boolean result = isValid("()[]{}");
        System.out.println("result = " + result);
    }

    public static boolean isValid(String s) {
        Stack<Bracket> bracketStack = new Stack<>();

        for (char c : s.toCharArray()) {
            Bracket bracket = new Bracket(c);

            // TODO 1. Stack 이 비어있는데 닫는 괄호 ? return false;
            if (bracketStack.isEmpty() && bracket.isClose()) {
                return false; // 여는 괄호가 없는데 닫는 괄호가 나왔기 때문에 문법 오류
            }

            // TODO 2. 닫는괄호가 나오면 Stack 을 peek()해서 같은 종류인지 비교 -> true? bracketStack.pop();, false? return false;
            if (bracket.isClose()) {
                if (!bracketStack.peek().isPair(bracket)) { // 열/닫 괄호가 쌍이 아니기 때문에 문법 오류
                    return false;
                }
                bracketStack.pop();
            } else {
                bracketStack.push(bracket);
            }
        }

        // TODO 3. 반복문 종료 후 Stack 이 비어있지 않으면? return false;
        return bracketStack.isEmpty();
    }

    static class Bracket {
        private final Type type;
        private final Size size;

        public Bracket(Character value) {
            this.type = isOpenBracket(value) ? Type.OPEN : Type.CLOSE;
            this.size = Size.convert(value);
        }

        public boolean isClose() {
            return type.equals(Type.CLOSE);
        }

        public boolean isPair(Bracket bracket) {
            return !type.equals(bracket.type) && size.equals(bracket.size);
        }

        private static boolean isOpenBracket(Character value) {
            return value.equals('(') || value.equals('{') || value.equals('[');
        }

        enum Type {
            OPEN,
            CLOSE;
        }

        enum Size {
            SMALL,
            MEDIUM,
            LARGE;

            static Size convert(Character value) {
                if (value.equals('(') || value.equals(')')) {
                    return Size.SMALL;
                } else if (value.equals('{') || value.equals('}')) {
                    return Size.MEDIUM;
                } else
                    return Size.LARGE;
            }
        }
    }
}