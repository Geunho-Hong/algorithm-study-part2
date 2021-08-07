package min.exhaustive_search.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 블랙잭 {

    static int n; // 카드 개수
    static int m; // 카드 숫자 최대 합

    static int[] cards;
    static boolean[] visit;

    static int max;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= m)
                        max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            cards = new int[n];
            visit = new boolean[n];

            line = br.readLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                cards[i] = Integer.parseInt(line[i]);
            }
        }
    }

}
