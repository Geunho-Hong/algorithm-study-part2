package guenho.sort;

import java.util.Arrays;
import java.util.Comparator;

public class FailureRate {
    public static void main(String[] args) {
        // case 1
        //int N = 5;
        //int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        // case 2
        int N = 4;
        int[] stages = {4,4,4,4,4};

        System.out.println(solution(N, stages));
    }

    /**
     * 실패율 = 스테이지에 도달했으나 클리어 하지 못한 플레이어 수
     *         / 스테이지에 도달한 플레이어의 수
     * @param N      : 전체 스테이지의 개수
     * @param stages : 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
     * @return
     */

    private static int[] solution(int N, int[] stages) {

        int idx = 0;
        int[] answer = {};
        int userCnt = stages.length;
        Stage[] stageArr = new Stage[N];

        for (int i = 1; i <= N; i++) {

            int stage = i;
            int stageCnt = 0;

            for (int j = 0; j < stages.length; j++) {
                if (stage == stages[j]) {
                    stageCnt++;
                }
            }

            double failure = 0;

            if(userCnt == 0 ) {
                // test case add +
                failure = 0;
            } else {
                failure = (double) stageCnt / userCnt;
            }

            stageArr[idx++] = new Stage(i, failure);
            userCnt -= stageCnt;
        }

        Arrays.sort(stageArr, new Comparator<Stage>() {
            @Override
            public int compare(Stage s1, Stage s2) {
                if(s1.failureRate == s2.failureRate) {
                    return s1.stage - s2.stage;
                } else if(s1.failureRate > s2.failureRate) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        answer = new int[N];

        for (int i = 0; i < stageArr.length; i++) {
            answer[i] = stageArr[i].stage;
        }

        return answer;
    }


    // Comparator -> Comparable
    private static class Stage {

        private int stage;
        private double failureRate;

        public Stage(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }
}
