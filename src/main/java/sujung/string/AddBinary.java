package sujung.string;

public class AddBinary {

    /**
     * Given two binary strings a and b, return their sum as a binary string
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

        int indexOfA = a.length();
        int indexOfB = b.length();

        StringBuilder result = new StringBuilder();

        int carry = 0;
        while (indexOfA > 0 || indexOfB > 0) {
            int temp = carry;

            if (indexOfA > 0) {
                temp += a.charAt(--indexOfA) - '0';
            }
            if (indexOfB > 0) {
                temp += b.charAt(--indexOfB) - '0';
            }

            result.append(temp % 2);
            carry = temp / 2;
//            if(temp == 0) {
//                result.append('0');
//                carry = 0;
//            } else if(temp == 1) {
//                result.append('1');
//                carry = 0;
//            } else if(temp == 2) {
//                result.append('0');
//                carry = 1;
//            } else if(temp == 3) {
//                result.append('1');
//                carry = 1;
//            }
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
