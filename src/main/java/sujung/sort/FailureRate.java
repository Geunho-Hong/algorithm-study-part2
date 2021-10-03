package sujung.sort;

import java.util.Arrays;

public class FailureRate {

    private static class StageInfo implements Comparable<StageInfo> {
        int index;
        int clearNum;
        int playingNum;

        public StageInfo(int index) {
            this.index = index;
            this.clearNum = 0;
            this.playingNum = 0;
        }

        @Override
        public int compareTo(StageInfo o) {
            double f1 = this.playingNum == 0 ? 0.0 : (double) this.playingNum / this.clearNum;
            double f2 = o.playingNum == 0 ? 0.0 : (double) o.playingNum / o.clearNum;
            if (f1 == f2) {
                return Integer.compare(this.index, o.index);
            }
            return Double.compare(f2, f1);
        }
    }

    /**
     * 실패율이 높은 스테이지부터 내림차순으로 반환
     * 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
     * @param N
     * @param stages
     * @return
     */
    public int[] solution(int N, int[] stages) {
        StageInfo[] stageInfos = new StageInfo[N];
        for (int i = 0; i < N; i++) {
            stageInfos[i] = new StageInfo(i + 1);
        }

        for (int index : stages) {
            for (int i = 0; i < (Math.min(index, N)); i++) {
                stageInfos[i].clearNum++;
            }
            if (index <= N) {
                stageInfos[index - 1].playingNum++;
            }
        }

        Arrays.sort(stageInfos);

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageInfos[i].index;
        }
        return answer;
    }
}
