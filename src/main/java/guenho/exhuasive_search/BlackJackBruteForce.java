package guenho.exhuasive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BlackJackBruteForce {

    private static int N, M;
    private static int[] cards;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            M = Integer.parseInt(commands[1]);

            cards = new int[N];

            String[] rows = br.readLine().split(" ");

            for (int i = 0; i < rows.length; i++) {
                cards[i] = Integer.parseInt(rows[i]);
            }

            // Brute force
            for (int i = 0; i < N-2; i++) {
                for (int j = i+1; j < N-1; j++) {
                    for (int k = j+1; k < N; k++) {
                        int temp = cards[i] + cards[j] + cards[k];
                        if(temp > M) {
                            continue;
                        }
                        max = Math.max(max,temp);
                    }
                }
            }

            System.out.println(max);

        }
    }
}
