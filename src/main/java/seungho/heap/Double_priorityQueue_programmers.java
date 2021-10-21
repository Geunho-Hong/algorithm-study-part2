package seungho.heap;

import java.util.*;

public class Double_priorityQueue_programmers {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (String s : operations) {
            String[] temp = s.split(" ");
            char operation = temp[0].charAt(0);
            int num = Integer.parseInt(temp[1]);
            if (operation == 'I'){
                maxQ.offer(num);
                minQ.offer(num);
            }else if(!maxQ.isEmpty() && !minQ.isEmpty()){ //연산이 'D' 일때
                if (num == 1){
                    int max = maxQ.poll();
                    minQ.remove(max);
                }else{
                    int min = minQ.poll();
                    maxQ.remove(min);
                }
            }
        }

        if(!maxQ.isEmpty())
            answer[0] = maxQ.poll();
        if(!minQ.isEmpty())
            answer[1] = minQ.poll();
        return answer;
    }

}
