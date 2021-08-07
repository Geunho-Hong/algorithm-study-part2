package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class StartLink {
    private static int N;
    private static int[][] capabilities;
    private static boolean[] startTeam;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            N = parseInt(br.readLine());
            capabilities = new int[N][N];
            startTeam = new boolean[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    capabilities[i][j] = parseInt(st.nextToken());
                }
            }

            go(0, 0);
            System.out.println(result);
        }
    }

    /**
     * N/2개의 수를 골라 팀을 구성하는 함수 (조합)
     * @param index
     * @param selected
     */
    private static void go(int index, int selected) {
        if (selected == N / 2) {
            int startCapa = computeCapaOfTeam(true);
            int linkCapa = computeCapaOfTeam(false);
            int diff = startCapa - linkCapa > 0 ? startCapa - linkCapa : linkCapa - startCapa;
            result = Math.min(result, diff);
            return;
        }
        if (index >= N) {
            return;
        }

        for (int i = index; i < N; i++) {
            if(startTeam[i]) continue;
            startTeam[i] = true;
            go(i + 1, selected + 1);
            startTeam[i] = false;
        }

    }

    /**
     * 팀 능력치를 구하는 함수
     * @param isStartTeam
     * @return
     */
    private static int computeCapaOfTeam(boolean isStartTeam) {
        int capaSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (startTeam[i] == isStartTeam && startTeam[j] == isStartTeam) {
                    capaSum += capabilities[i][j];
                    capaSum += capabilities[j][i];
                }
            }
        }
        return capaSum;
    }
}
