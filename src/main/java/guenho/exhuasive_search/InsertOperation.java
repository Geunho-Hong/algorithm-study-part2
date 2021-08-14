package guenho.exhuasive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://st-lab.tistory.com/121
// 순열을 다 구하고 하는 개념의로 접근하는게 아님

public class InsertOperation {

    private static int N;
    private static int[] arr;
    private static int[] operation;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;

    private static void recursive(int num, int depth) {
        if (depth == N) {

            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        // 반복문을 돌면서 하나씩 재귀 호출
        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                switch (i) {
                    case 0:
                        recursive(num + arr[depth], depth + 1);
                        break;
                    case 1:
                        recursive(num - arr[depth], depth + 1);
                        break;
                    case 2:
                        recursive(num * arr[depth], depth + 1);
                        break;
                    case 3:
                        recursive(num / arr[depth], depth + 1);
                        break;
                }
                operation[i]++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            operation = new int[4];

            String[] row = br.readLine().split(" ");

            // 수 담기
            for (int i = 0; i < row.length; i++) {
                arr[i] = Integer.parseInt(row[i]);
            }

            String[] operLine = br.readLine().split(" ");

            // 연산자 담기
            for (int i = 0; i < operLine.length; i++) {
                operation[i] = Integer.parseInt(operLine[i]);
            }

            recursive(arr[0], 1);

            System.out.println(MAX);
            System.out.println(MIN);
        }
    }
}
