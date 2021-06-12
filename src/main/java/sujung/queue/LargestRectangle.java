package sujung.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LargestRectangle {

    public static long largestRectangle(List<Integer> h) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i < h.size(); i++) {
            int currentHeight = h.get(i);
            if (!stack.isEmpty() && h.get(stack.peek()) <= currentHeight) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && h.get(stack.peek()) > currentHeight) {
                    int tempMinimum = h.get(stack.pop());
                    if (stack.isEmpty()) {
                        maxArea = Math.max(maxArea, tempMinimum * i);
                    } else {
                        maxArea = Math.max(maxArea, tempMinimum * (i - stack.peek() - 1));
                    }
                }
                stack.push(i);
            }
        }

        if (!stack.isEmpty()) {
            int i = h.size();
            while (!stack.isEmpty()) {
                int tempMinimum = h.get(stack.pop());
                if (stack.isEmpty()) {
                    maxArea = Math.max(maxArea, tempMinimum * i);
                } else {
                    maxArea = Math.max(maxArea, tempMinimum * (i - stack.peek() - 1));
                }
            }
        }
        return maxArea;
    }
}
