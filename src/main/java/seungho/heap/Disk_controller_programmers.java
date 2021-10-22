package seungho.heap;

import java.util.*;

public class Disk_controller_programmers {
    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; //끝나는 시간
        int jobsIdx = 0;
        int count = 0; // 수행된 요청 갯수

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {
            // 큐에 추가
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }


            if (pq.isEmpty()) { // 큐가 비어있을때 끝나는 시간을 배열의 요청되는 시점으로 설정
                end = jobs[jobsIdx][0];
            } else { // 작업 수행
                int[] now = pq.poll();
                count++; // 작업수행 완료
                end += now[1]; // 끝나는 시간 변경
                answer += end - now[0]; // 대기시간
            }

        }
        return (int) Math.floor(answer / jobs.length);
    }
}
