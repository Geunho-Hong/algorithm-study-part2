package min.exhaustive_search.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 막대기 {

    static int X;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            X = Integer.parseInt(br.readLine());
        }

        // 길이 -> 64 32 16 8 4 2 1 (7 가지)
        int barCount = 0;

        // 10111 & (1 << i)  1000000
        // 00001
        // 00010
        // 00100
        // 01000
        // 10000
        for (int i = 0; i < 7; i++) {
            if ((X & (1 << i)) > 0)
                barCount++;
        }

        System.out.println(barCount);
    }

}