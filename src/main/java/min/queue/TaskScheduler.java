package min.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        // 문자와 개수로 매핑
        Map<Character, Integer> countMap = new HashMap<>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

        // 문자 개수를 내림차순으로 Queue 에 쌓음
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(countMap.values());

        int max = queue.poll();
        int idle = (max - 1) * n; // 가장 많은 task(A) 를 기준으로 유휴시간을 계산함 (개수 -1 ) * n
        while (!queue.isEmpty()) {
            // 다른 작업으로 중간중간 유휴 시간을 채워줌
            // 하지만 A - 1 작업 이상만큼 채워줄 수 없기때문에 최대 수 제한
            idle -= Math.min(queue.poll(), max - 1);
        }

        // idle 은 음수일 수 없음 (n이 0이면 idle 이 음수가 되기 때문에 음수일 경우 0으로 변경)
        return tasks.length + Math.max(idle, 0);
    }

}
