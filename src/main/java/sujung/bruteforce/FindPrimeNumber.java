package sujung.bruteforce;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class FindPrimeNumber {

    private boolean[] isNotPrime = new boolean[10_000_000];
    private String num;
    private boolean[] check;
    private Set<Integer> set;

    public int solution(String numbers) {
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i < 10_000_000; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < 10_000_000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        num = numbers;
        set = new HashSet<>();
        for (int i = 1; i <= num.length(); i++) {
            check = new boolean[num.length()];
            go(i, new StringBuilder());
        }
        return set.size();
    }

    public void go(int length, StringBuilder sb) {
        if (sb.length() == length) {
            int temp = parseInt(sb.toString());
            if (!isNotPrime[temp]) {
                set.add(temp);
            }
            return;
        }
        for (int i = 0; i < num.length(); i++) {
            if (check[i]) continue;
            check[i] = true;
            go(length, new StringBuilder(sb).append(num.charAt(i)));
            check[i] = false;
        }
    }
}
