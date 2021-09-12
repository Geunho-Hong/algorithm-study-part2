package guenho.dp;

import java.util.Scanner;
// https://loosie.tistory.com/391
//https://hoho325.tistory.com/240
//https://blog.encrypted.gg/974?category=773649

/**
 * 1. 테이블 정의
 * 2. 점화식 찾기
 * 3. 초기값 정하기
 */

public class MakeNumberOne {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dist = new int[N + 1];

        dist[1] = 0;    // 1로 만들기

        for (int i = 2; i <= N; i++) {
            dist[i] = dist[i - 1] + 1;
            // +1은 연산 횟수
            if (i % 2 == 0) {
                dist[i] = Math.min(dist[i], dist[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dist[i] = Math.min(dist[i], dist[i / 3] + 1);
            }
        }

        System.out.println(dist[N]);

    }
}
