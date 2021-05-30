package thkim.hash;

import java.util.Arrays;
import java.util.HashMap;

public class HashLevel2 {

    // https://programmers.co.kr/learn/courses/30/lessons/42577
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        HashMap<String, String> checker = new HashMap<>();

        for (String arg : phone_book) {
            checker.put(arg, arg);

            for (int i = 0; i < arg.length(); i++) {
                String mini = arg.substring(0, i);

                if (checker.get(mini) != null) {
                    answer = false;
                    break;
                }
            }

            if (!answer) break;
        }
        return answer;
    }

    public boolean solution__(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
