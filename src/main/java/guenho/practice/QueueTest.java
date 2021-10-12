package guenho.practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        int[] arr = {5,3,2,1};
        Queue<Integer> queue = new LinkedList<>();

        for(int num : arr) {
            queue.add(num);
        }

        System.out.println("Before");
        for(int q : queue) {
            System.out.println(q);
        }

        int peek = queue.peek();
        int poll = queue.poll();

        System.out.println("After");
        for(int q : queue) {
            System.out.println(q);
        }

    }
}
