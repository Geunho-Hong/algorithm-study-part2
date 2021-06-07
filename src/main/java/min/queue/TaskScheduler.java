package min.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(countMap.values());

        int max = queue.poll();
        int idle = (max - 1) * n;
        while (!queue.isEmpty()) {
            idle -= Math.min(queue.poll(), max - 1);
        }

        return tasks.length + Math.max(idle, 0);
    }

}
