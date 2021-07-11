package guenho.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String revereStr = br.readLine();
        char[] reverseCharArr = revereStr.toCharArray();

        int front = 0;
        int rear = reverseCharArr.length - 1;
        int len = reverseCharArr.length / 2;

        for (int i = 0; i < len; i++) {
            char tempChar = reverseCharArr[front];
            reverseCharArr[front++] = reverseCharArr[rear];
            reverseCharArr[rear--] = tempChar;
        }

        System.out.println(reverseCharArr);

    }
}
