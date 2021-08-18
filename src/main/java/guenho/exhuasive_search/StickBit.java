package guenho.exhuasive_search;

import java.util.Scanner;

public class StickBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int cnt = 0;

        // 막대기의 개수 : 64,32,16,8,4,2,1
        for (int i = 0; i < 7; i++) {
            // 양쪽 비트가 모두 1이면 1 반환
            if((num & (1<<i)) > 0) {
                cnt++;
            }
        }
    }
}
