package guenho.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

// Question : https://programmers.co.kr/learn/courses/30/lessons/42583
public class PassingThroughTheBridge {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weight = {7, 4, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weight));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weight) {
        int answer = 0;
        int bridgeWeight = 0;

        Queue<Truck> bridge = new LinkedList<>(); // 다리를 지나는 트럭 큐
        Queue<Integer> waitQ= new LinkedList<>(); // 대기하는 트럭 큐

        // 기다리는 트럭을 큐에 넣는다
        for(int num : truck_weight){
            waitQ.add(num);
        }

        // 첫번째 트럭이 준비
        bridge.add(new Truck(waitQ.poll()));

        do{
            // 다리에 있는 트럭 이동 및 체크 (1개면 1개, 여러개가 이동 가능할수도있음)
            for(Truck truck : bridge){
                truck.sec++; // 다리를 건너는 트럭의 시간 증가

                // 트럭이 다리 끝에 도착한 경우
                if(truck.sec == bridge_length) {
                    bridgeWeight-=truck.weight;
                }

                // 트럭이 다리를 건너기 시작하면 다리 무게 증가
                if(truck.sec == 1){
                    bridgeWeight+=truck.weight;
                }
            }

            // 남은 트럭이 있고, 출발 할수 있으면 준비
            if(!waitQ.isEmpty() && bridgeWeight + waitQ.peek() <= weight){
                bridge.add(new Truck(waitQ.poll()));
            }
            // 다리를 건넌 트럭은 poll
            if(bridge.peek().sec > bridge_length){
                bridge.poll();
            }
            answer++;

        }while(!bridge.isEmpty()); // 다리에 있는 트럭이 전부 빠질 때 까지

        return answer;
    }

    static class Truck{
        int weight;
        int sec;

        public Truck(int weight){
            this.weight = weight;
        }
    }

}
