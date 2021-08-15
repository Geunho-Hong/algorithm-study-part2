package min.string;

import java.math.BigInteger;

public class AddStrings {

    public static void main(String[] args) {
        String result = new AddStrings().addStrings("11", "123");
        System.out.println("result = " + result);
    }

    public String addStrings(String num1, String num2) {
        // 큰 정수를 처리하기 위한 빌트인 라이브러리 사용 금지
        // 인풋 String 값을 바로 Integer 로 변환 금지
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            if (carry != 0) {
                sum += carry;
                carry = 0;
            }

            if (sum > 9) carry = 1;

            sb.append(sum % 10);
        }
        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }

}
