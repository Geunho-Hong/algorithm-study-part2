package guenho.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class PhoneNumberHash {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        System.out.println(solution(phone_book));
    }

    private static boolean solution(String[] phone_book) {
        HashMap<String, String> phoneMap = new LinkedHashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            phoneMap.put(phone_book[i],phone_book[i]);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if(phoneMap.containsKey(phone_book[i].substring(0,j))) {
                    /**
                     *  자기 자신을 제외한 Key 값 체크 하기
                     */
                    return false;
                }
            }
        }
        return true;
    }
}
