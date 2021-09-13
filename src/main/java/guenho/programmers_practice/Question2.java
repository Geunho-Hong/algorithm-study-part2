package guenho.programmers_practice;

import java.util.Arrays;

// 비밀 지도
public class Question2 {
    public static void main(String[] args) {
        int n = 5;

        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] answer = new String[n];

        // 1. 한 개라도 벽이면 전체 지도는 모두 벽이다
        // 2. 모두 공백인 부분은 전체 지도에서도 공백이다

        for (int i = 0; i < arr1.length; i++) {
            String decode = "";
            String arr1Decode = decoding(arr1[i], n);
            String arr2Decode = decoding(arr2[i], n);

            for (int j = 0; j < arr1Decode.length(); j++) {
                if (arr1Decode.charAt(j) == '1' || arr2Decode.charAt(j) == '1') {
                    decode += "#";
                } else if (arr1Decode.charAt(j) == '0' && arr2Decode.charAt(j) == '0') {
                    decode += " ";
                }
            }
            answer[i] = decode;
        }

        Arrays.stream(answer).forEach(e -> System.out.println(e + " "));
    }

    public static String decoding(int num, int len) {

        // toBinaryString 으로 2진수,4진수,8진수 변환 가능
        String answer = "";

        while(num > 0) {
            // answer+= 에 고착될 필요가 없다.
            answer = num%2 + answer;
            num/=2;
        }

        while(answer.length() != len) {
            answer = "0" + answer;
        }

        return answer;
    }

}
