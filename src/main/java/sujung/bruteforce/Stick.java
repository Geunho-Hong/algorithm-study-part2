package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Stick {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            int X = parseInt(br.readLine());
            int count = 0;

            int i = 6;
            while (i >= 0 && X > 0) {
                int n = (1 << i);   // left shift
                if (X >= n) {
                    X -= n;
                    count++;
                }
                i--;
            }
            System.out.println(count);
        }
    }
}
