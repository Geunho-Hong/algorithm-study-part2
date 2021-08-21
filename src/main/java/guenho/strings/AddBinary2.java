package guenho.strings;

public class AddBinary2 {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {

        int aLength = a.length() - 1;
        int bLength = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int idx = 0;

        while (sum > 0 || aLength >= 0 || bLength >= 0) {

            if (aLength >= 0) {
                sum += a.charAt(aLength--) - '0';
            }
            if (bLength >= 0) {
                sum += b.charAt(bLength--) - '0';
            }
            sb.append(sum % 2);
            sum /= 2;

            idx ++;
        }

        return sb.reverse().toString();
    }
}
