package guenho.strings;

/**
 * Convert String to Integer
 * Get digit
 */
public class Digits {
    public static void main(String[] args) {
        String str = "56392";
        int num = Integer.parseInt(str);

        /**
         * 규칙 :
         * mod 연산자는 자릿수 + 1
         * divide 연산자는 자릿수
         */

        System.out.println("10000 = " + num / 10000);
        System.out.println("1000 = " + (num % 10000) / 1000);
        System.out.println("100 = " + (num % 1000) / 100);
        System.out.println("10 = " + (num % 100) / 10);
        System.out.println("1 = " + num % 10);
    }
}
