package min.string;

public class AddBinary {

    public static void main(String[] args) {
        String s = new AddBinary().addBinary("101101", "1001");
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            if (carry > 0) {
                sum += carry; // 1 옮겨준 후 다시 0 초기화
                carry = 0;
            }

            if (sum >= 2) carry = 1;

            // 2진수이기 때문에 0 1 2 3 값에 대해서 나머지 값을 넣어줌
            sb.append(sum % 2);
        }
        // 마지막에 carry애 값이 남아있으면 맨 앞에 붙여줘야함
        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }

}