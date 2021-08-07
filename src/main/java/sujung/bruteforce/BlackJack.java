package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class BlackJack {
    private static final int CARD_NUM = 3;
    private static int N;
    private static int M;
    private static int[] nums;
    private static boolean[] used;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            nums = new int[N];
            used = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                nums[i] = parseInt(st.nextToken());
            }

            go(0, 0, 0);
            System.out.println(result);
        }
    }

    /**
     * 3개 수를 골라 합을 구하는 함수 (조합)
     * @param index
     * @param selected
     * @param currentSum
     */
    private static void go(int index, int selected, int currentSum) {
        if(index >= nums.length || currentSum > M) {
            return;
        }

        if(selected >= CARD_NUM) {
            result = Math.max(currentSum, result);
            return;
        }

        for(int i=index; i< nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            go(index + 1, selected + 1, currentSum + nums[i]);
            used[i] = false;
        }
    }
}
