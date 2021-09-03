package guenho.dp;

import kotlin.jvm.internal.PropertyReference0Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin1 {

    private static int N,K;
    private static int[] coins;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            K = Integer.parseInt(commands[1]);

            coins = new int[N];

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }
        }
    }
}
