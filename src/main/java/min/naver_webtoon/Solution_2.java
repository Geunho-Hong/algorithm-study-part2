package min.naver_webtoon;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution_2 {

    public String[] solution(String s) {
        ArrayDeque<String> sRes = new ArrayDeque<>();
        ArrayDeque<String> eRes = new ArrayDeque<>();

        char[] chars = s.toCharArray();
        int startIdx = 0;
        int endIdx = chars.length - 1;

        ArrayDeque<Character> queue = new ArrayDeque<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        while (startIdx <= endIdx) {
            if ((startIdx == endIdx || startIdx == (endIdx - 1)) && !Arrays.equals(dequeToArr(queue, Type.QUEUE), dequeToArr(stack, Type.STACK))) {
                queue.offer(chars[startIdx]);
                sRes.addLast(dequeToString(queue, Type.QUEUE) + dequeToString(stack, Type.STACK));
                break;
            }

            queue.offer(chars[startIdx++]);
            stack.push(chars[endIdx--]);

            if (Arrays.equals(dequeToArr(queue, Type.QUEUE), dequeToArr(stack, Type.STACK))) {
                sRes.addLast(dequeToString(queue, Type.QUEUE));
                queue.clear();

                eRes.addFirst(dequeToString(stack, Type.STACK));
                stack.clear();
            }
        }

        String[] res = new String[sRes.size() + eRes.size()];
        int resIdx = 0;

        while (!sRes.isEmpty()) {
            res[resIdx++] = sRes.pollFirst();
        }

        while (!eRes.isEmpty()) {
            res[resIdx++] = eRes.pollFirst();
        }

        return res;
    }

    private char[] dequeToArr(ArrayDeque<Character> deque, Type type) {
        ArrayDeque<Character> tempDeque = deque.clone();
        char[] res = new char[tempDeque.size()];
        int i = 0;
        while (!tempDeque.isEmpty()) {
            if (type.equals(Type.QUEUE))
                res[i++] = tempDeque.poll();
            else if (type.equals(Type.STACK))
                res[i++] = tempDeque.pop();
        }
        return res;
    }

    private String dequeToString(ArrayDeque<Character> deque, Type type) {
        ArrayDeque<Character> tempDeque = deque.clone();
        StringBuilder sb = new StringBuilder();
        while (!tempDeque.isEmpty()) {
            if (type.equals(Type.QUEUE)) sb.append(tempDeque.poll());
            else if (type.equals(Type.STACK)) sb.append(tempDeque.pop());
        }
        return sb.toString();
    }

    enum Type {
        QUEUE,
        STACK;
    }

}
