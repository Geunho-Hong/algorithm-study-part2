package min.queue;

import kotlin.coroutines.AbstractCoroutineContextKey;

import java.io.IOException;
import java.util.*;

public class LargestRectangle {

    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());

        List<Integer> h = new ArrayList<>();
        h.add(1);
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        long result = largestRectangle(h);
        System.out.println("result = " + result);
    }

    public static long largestRectangle(List<Integer> h) {
        Deque<Integer> stack = new ArrayDeque<>();
        int largestArea = 0;
        int i = 0;

        while (i < h.size()) {
            if (stack.isEmpty() || h.get(stack.peek()) < h.get(i)) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int area;

                if (stack.isEmpty()) {
                    area = h.get(top) * i;
                } else {
                    area = h.get(top) * (i - stack.peek() - 1);
                }

                if (largestArea < area) {
                    largestArea = area;
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area;

            if (stack.isEmpty()) {
                area = h.get(top) * i;
            } else {
                area = h.get(top) * (i - stack.peek() - 1);
            }

            if (largestArea < area) {
                largestArea = area;
            }
        }

        return largestArea;
    }

}
