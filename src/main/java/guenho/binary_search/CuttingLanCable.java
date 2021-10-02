package guenho.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuttingLanCable {

    private static long min = 1;
    private static long max = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            int K = Integer.parseInt(commands[0]);
            int N = Integer.parseInt(commands[1]);

            int[] line = new int[K];

            for (int i = 0; i < K; i++) {
                line[i] = Integer.parseInt(br.readLine());
                max = Math.max(line[i], max);
            }

            while (min <= max) {
                long mid = (min + max) / 2;
                long cnt = 0;

                for (int num : line) {
                    cnt += num / mid;
                }

                if (cnt >= N) {
                    min = mid + 1;
                } else if (cnt < N) {
                    max = mid - 1;
                }
            }
            System.out.println(max);
        }
    }

}
