package min.exhaustive_search.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연산자_끼워넣기 {

    static int N;
    static int[] A;
    static char[] operator;
    static boolean[] visit;

    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        permutation(0);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void permutation(int depth) {
        if (depth == (N - 1)) {
            int calc = calc();
            maxResult = Math.max(maxResult, calc);
            minResult = Math.min(minResult, calc);
            return;
        }

        //TODO: 연속된 같은 연산자에 대한 순열 알고리즘 초적화하기
        for (int i = depth; i < N - 1; i++) {
            swap(i, depth);
            permutation(depth + 1);
            swap(i, depth);
        }
    }

    static void swap(int a, int b) {
        char temp = operator[a];
        operator[a] = operator[b];
        operator[b] = temp;
    }

    // 완성된 operator 순열에 대한 계산
    static int calc() {
        int result = A[0];

        for (int i = 0; i < N - 1; i++) {
            if (operator[i] == '+') result += A[i + 1];
            else if (operator[i] == '-') result -= A[i + 1];
            else if (operator[i] == '*') result *= A[i + 1];
            else if (operator[i] == '/') result /= A[i + 1];
            else throw new IllegalStateException("적합하지 않은 연산자입니다.");
        }

        return result;
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            A = new int[N];
            operator = new char[N - 1];
            visit = new boolean[N - 1];

            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < inputs.length; i++)
                A[i] = Integer.parseInt(inputs[i]);

            inputs = br.readLine().split(" ");
            int operatorIndex = 0;
            for (int i = 0; i < inputs.length; i++) {
                int operatorCount = Integer.parseInt(inputs[i]);
                for (int j = 0; j < operatorCount; j++) {
                    if (i == 0) operator[operatorIndex++] = '+';
                    else if (i == 1) operator[operatorIndex++] = '-';
                    else if (i == 2) operator[operatorIndex++] = '*';
                    else if (i == 3) operator[operatorIndex++] = '/';
                }
            }
        }
    }

}
