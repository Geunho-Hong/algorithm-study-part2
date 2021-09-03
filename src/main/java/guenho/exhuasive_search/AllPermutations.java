package guenho.exhuasive_search;

// https://bcp0109.tistory.com/14

import java.util.Scanner;

/**
 * 1.swap을 이용한 순열 -> 순서가 보장되지 않는다
 * 2.visited 배열을 통한 방문체크 -> 순서가 보장된다
 */

public class AllPermutations {

    private static int N;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // arr = new int[N];
        visited = new boolean[N];

        arr = new int[]{1,2,3};

        //dfs(0, N);
        permutation(0,N);
    }

    /**
     * permutation -> swap의 경우 미리 배열을 선언해 놓고 사용
     * @param depth
     * @param N
     */

    static void permutation(int depth, int N) {
        if (depth == N) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < N; i++) {
            swap(depth, i);
            permutation(depth + 1, N);
            swap(depth, i);
        }
    }

    static void swap(int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    /**
     * visited permutation
     *
     * @param depth
     * @param N
     */
    static void dfs(int depth, int N) {
        if (depth == N) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, N);
                visited[i] = false;
            }
        }
    }
}
