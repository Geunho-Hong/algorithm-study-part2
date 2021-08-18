package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertOperator {

    private static int[] nums;
    private static int[] op;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int size = Integer.parseInt(br.readLine());
            nums = new int[size];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            op = new int[4];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }

            go(1, 0);

            System.out.println(max);
            System.out.println(min);
        }
    }

    /**
     * 연산자를 끼워넣을 수 있는 경우를 완전 탐색하여 연산 결과의 최소, 최대 값을 구한다.
     * @param index
     * @param result
     */
    private static void go(int index, int result) {
        if (index > nums.length) {
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        if (index == 1) {
            go(index + 1, nums[index - 1]);
        } else {
            for (int i = 0; i < 4; i++) {
                if (op[i] <= 0) continue;
                op[i] -= 1;

                if (i == 0) {
                    go(index + 1, result + nums[index - 1]);
                } else if (i == 1) {
                    go(index + 1, result - nums[index - 1]);
                } else if (i == 2) {
                    go(index + 1, result * nums[index - 1]);
                } else {
                    go(index + 1, result / nums[index - 1]);
                }

                op[i] += 1;
            }
        }
    }
}
