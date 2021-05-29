package min.hash;

import java.util.*;

public class 전화번호_목록 {

    public static void main(String[] args) {
//        String[] phoneBook = {"39475934759", "119", "97674223", "1195524421"};
        String[] phoneBook = {"12","123","1235","567","88"};
        boolean result = solution(phoneBook);
        System.out.println("result = " + result);
    }

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook, Comparator.comparing(String::length));

        int initialCapacity = (int) (phoneBook.length * 1.3);
        Map<String, Void> map = new HashMap<>(initialCapacity);

        for (String phoneNumber : phoneBook) {
            // 12 88 123 567 1235
            for (int i = phoneBook[0].length(); i <= phoneNumber.length(); i++) {
                String key = phoneNumber.substring(0, i);
                System.out.printf("[COMPARE] key = %s%n", key);

                if (map.containsKey(key)) {
                    return false;
                }

                if (phoneNumber.equals(key)) {
                    System.out.printf("[SAVE] phoneNumber = %s, key = %s%n", phoneNumber, key);
                    map.put(key, null);
                }
            }
        }

        return true;
    }
}
