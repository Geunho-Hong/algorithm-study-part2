import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] A;

    static int maxSum;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                int i1 = A[j - 1] - A[j];
            }
        }

        System.out.println(maxSum);
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            A = new int[N];

            String[] strArr = br.readLine().split(" ");
            for (int i = 0; i < strArr.length; i++) {
                A[i] = Integer.parseInt(strArr[i]);
            }
        }
    }
}
