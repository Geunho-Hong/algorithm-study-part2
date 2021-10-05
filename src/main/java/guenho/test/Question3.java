package guenho.test;

import java.util.Collections;
import java.util.PriorityQueue;

public class Question3 {

    private static int truck = 0;

    public static void main(String[] args) {
        int[] v = {4,5,5};
        int a = 2; // 선두 트럭의 시간당 연료 소비량
        int b = 1; // 후위 트럭의 연료 소비량

        System.out.println(solution(v,a,b));
    }

    private static int solution(int[] v, int a, int b) {

        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int oil : v) {
            queue.add(oil);
        }

        int idx = 0;
        while(!queue.isEmpty()) {
            truck = queue.poll();

            if(idx == 0) {
                // 첫번째 트럭이면 -a;
                truck -= a;
            } else {
                // 두번째 트럭이면 -b;
                truck -= b;
            }

            if(truck > 0) {
                queue.add(truck);
            }

            idx++;

            if(queue.size() == idx && truck != 0) {
                result ++;
                idx = 0;
            }
        }
        return result;
    }
}