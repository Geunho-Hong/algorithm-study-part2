package min.exhaustive_search.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진수_연산 {

    static int[] A = new int[100_000];
    static int[] B = new int[100_000];

    static int length;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        // AND
        for (int i = 0; i < length; i++)
            sb.append(A[i] & B[i]);
        sb.append("\n");

        // OR
        for (int i = 0; i < length; i++)
            sb.append(A[i] | B[i]);
        sb.append("\n");

        // XOR
        for (int i = 0; i < length; i++)
            sb.append(A[i] ^ B[i]);
        sb.append("\n");

        // ~A
        for (int i = 0; i < length; i++)
            sb.append(A[i] ^ 1);
        sb.append("\n");

        // ~B
        for (int i = 0; i < length; i++)
            sb.append(B[i] ^ 1);
        sb.append("\n");

        System.out.println(sb);
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] binaries = br.readLine().split("");
            length = binaries.length;

            for (int i = 0; i < length; i++)
                A[i] = Integer.parseInt(binaries[i]);

            binaries = br.readLine().split("");
            for (int i = 0; i < length; i++)
                B[i] = Integer.parseInt(binaries[i]);
        }
    }

}