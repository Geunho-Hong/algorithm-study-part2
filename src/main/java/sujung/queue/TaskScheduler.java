package sujung.queue;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 최대힙
        pq.addAll(map.values());

        int count = 0;
        int cycle = n + 1;
        List<Integer> onceUsed = new ArrayList<>();

        while (!pq.isEmpty()) {
            int handledInCycle = 0;
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    Integer cur = pq.poll();
                    cur--;
                    handledInCycle++;
                    if (cur > 0) onceUsed.add(cur);
                }
            }
            pq.addAll(onceUsed);
            onceUsed.clear();

            count += (!pq.isEmpty()) ? cycle : handledInCycle; // idle 포함 or 실제 처리된 문자 개수
        }

        return count;
    }

}
