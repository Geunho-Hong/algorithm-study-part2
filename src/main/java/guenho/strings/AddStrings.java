package guenho.strings;

public class AddStrings {
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "1234";

        System.out.println(addString(num1, num2));
    }

    private static String addString(String num1, String num2) {

        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        while (sum > 0 || num1Length >= 0 || num2Length >= 0) {
            if (num1Length >= 0) {
                sum += num1.charAt(num1Length--) - '0';
            }
            if (num2Length >= 0) {
                sum += num2.charAt(num2Length--) - '0';
            }
            sb.append(sum % 10);
            sum /= 10;
        }

        return sb.reverse().toString();
    }
}
