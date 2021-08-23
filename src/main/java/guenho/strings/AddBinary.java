package guenho.strings;

public class AddBinary {

    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {

        String result = "";

        try {

            /**
             * 이진수 변환 Long.parseLong
             * 범위 초과로 인해 Wrong Answer
             */

            int aLength = a.length() - 1;
            int bLength = b.length() - 1;

            if (aLength >= 1 && bLength <= 10000) {
                long num1 = Long.parseLong(a, 2);
                long num2 = Long.parseLong(b, 2);
                result = Long.toBinaryString(num1 + num2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
