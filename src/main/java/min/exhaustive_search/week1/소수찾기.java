package min.exhaustive_search.week1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 소수찾기 {

    int n;
    String[] numbers;
    boolean[] isInclude;

    List<String> powerSet = new ArrayList<>(); // numbers에 대한 멱집합
    Set<Integer> permutationList = new HashSet<>(); // subset에 대한 순열

    StringBuilder sb = new StringBuilder();

    // 모든 부분집합에 대해서 순열 알고리즘을 활용하여 모든 값이 소수인지 확인하는 로직이 필요함
    public int solution(String numbers) {
        int answer = 0;

        this.n = numbers.length();
        this.numbers = numbers.split("");
        this.isInclude = new boolean[n];

        powerSet(0);
        powerSet.forEach(subset -> permutation(subset.split(""), 0));

//        permutationList.forEach(System.out::println);

        for (int p : permutationList) {
            if (isPrime(p)) answer++;
        }

        return answer;
    }

    // 멱집합 (https://taesan94.tistory.com/60)
    void powerSet(int depth) {
        if (n == depth) {
            for (int i = 0; i < n; i++) {
                if (isInclude[i])
                    sb.append(numbers[i]);
            }
            powerSet.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        isInclude[depth] = true;
        powerSet(depth + 1);

        isInclude[depth] = false;
        powerSet(depth + 1);
    }

    void permutation(String[] subsets, int depth) {
        if (depth == subsets.length) {
            for (String subset : subsets) {
                sb.append(subset);
            }

            if(sb.length() >= 1)
                permutationList.add(Integer.parseInt(sb.toString()));

            sb.delete(0, sb.length());
            return;
        }

        for (int i = depth; i < subsets.length; i++) {
            swap(subsets, depth, i);
            permutation(subsets, depth + 1);
            swap(subsets, depth, i);
        }
    }

    void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    boolean isPrime(int number) {
        if (number == 2) return true;
        if (number % 2 == 0 || number <= 1) return false;

        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        소수찾기 소수찾기 = new 소수찾기();
        String numbers = "011";
        System.out.println(소수찾기.solution(numbers));
    }
}
