package guenho.exhuasive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://moonsbeen.tistory.com/272?category=1184369
// https://www.acmicpc.net/problem/2661
// https://mygumi.tistory.com/213

public class GoodSequence {

    // 우선 1,2,3 으로 접근 가능한 수열을 make 해보자!
    private static int N;
    private static boolean isFlag;
    private static StringBuilder sb = new StringBuilder();

    private static boolean isGoodSequence(String s) {
        int len = s.length() / 2;
        int front = s.length() - 1;
        int rear = s.length();
        for (int i = 1; i <= len; i++) {
            if(s.substring(front-i,rear-i).equals(s.substring(front,rear))) {
                return false;
            }
            front -=1;
        }
        return true;
    }

    static void recursive(String s, int depth) {
        if(isFlag){return;}
        if (depth == N) {
            System.out.println(s);
            isFlag = true;
            return;
        }
        for (int i = 1; i <=3 ; i++) {
            if(isGoodSequence(s+i)) {
                recursive(s+i, depth +1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());
            recursive("1",1);

        }
    }
}
