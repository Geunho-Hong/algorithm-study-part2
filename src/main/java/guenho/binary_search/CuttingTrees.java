package guenho.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuttingTrees {

    private static int N, M;
    private static int[] trees;
    private static int ans = 0;
    private static long min, max = 0;

    // 1. 잘랐을때 M의 높이를 넘으면 자르는 높이를 키운다다
    // 2. 잘랐을때 M의 높이에 모자라면 자르는 높이를 줄인다

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            M = Integer.parseInt(commands[1]);

            trees = new int[N];

            String[] str = br.readLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                trees[i] = Integer.parseInt(str[i]);
                max = Math.max(trees[i], max);
            }

            // 찾는 인덱스에 한정 지어 생각할 필요가 없다
            while (min <= max) {
                long mid = (min + max) / 2;
                long sum = 0;

                for (int tree : trees) {
                    if (tree > mid) {
                        sum += tree - mid;
                    }
                }

                if (sum >= M) {
                    // 합계가 더 많으면 자르는 크기를 늘린다
                    // 같을 경우에는 최대한 적게 자르기 위해 하한을 올린다
                    min = mid + 1;
                } else if (sum < M) {
                    // 합계가 더 적으면 자르는 크기를 줄인다
                    max = mid - 1;
                }
            }

            System.out.println(max);
        }
    }

}
