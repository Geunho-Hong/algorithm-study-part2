package guenho.exhuasive_search;

import java.util.Scanner;

public class Stick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int stick = 64;
        int cnt = 0;

        while(num > 0) {
            if(stick > num) {
                stick /=2;
            } else{
                cnt++;
                num -=stick;
            }
        }
        System.out.println(cnt);

    }
}
