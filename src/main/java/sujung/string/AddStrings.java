package sujung.string;

public class AddStrings {

    /**
     * return the sum of num1 and num2
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int index1 = num1.length();
        int index2 = num2.length();

        StringBuilder result = new StringBuilder();
        int carry = 0;

        while (index1 > 0 || index2 > 0) {
            int temp = carry;

            if (index1 > 0) {
                temp += num1.charAt(--index1) - '0';
            }
            if (index2 > 0) {
                temp = num2.charAt(--index2) - '0';
            }

            result.append(temp % 10);
            carry = temp / 10;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
