package guenho.programmers_practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 이 방법으로도 풀리지만 다른 Solve도 참고하자
 */

public class NumberStringAndWords {
    public static void main(String[] args) {
        String s = "123";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        String word = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);

            if (alpha >= '0' && alpha <= '9') {
                // 숫자 일 경우 append
                sb.append(alpha);
            } else {
                word += alpha;
                Map<String, String> map = diff(word);
                if (map.get("key").equals("true")) {
                    sb.append(map.get("word"));
                    word = "";
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private static Map<String, String> diff(String word) {
        Map<String, String> paramMap = new HashMap<>();

        switch (word) {
            case "zero":
                paramMap.put("word", "0");
                paramMap.put("key", "true");
                break;
            case "one":
                paramMap.put("word", "1");
                paramMap.put("key", "true");
                break;
            case "two":
                paramMap.put("word", "2");
                paramMap.put("key", "true");
                break;
            case "three":
                paramMap.put("word", "3");
                paramMap.put("key", "true");
                break;
            case "four":
                paramMap.put("word", "4");
                paramMap.put("key", "true");
                break;
            case "five":
                paramMap.put("word", "5");
                paramMap.put("key", "true");
                break;
            case "six":
                paramMap.put("word", "6");
                paramMap.put("key", "true");
                break;
            case "seven":
                paramMap.put("word", "7");
                paramMap.put("key", "true");
                break;
            case "eight":
                paramMap.put("word", "8");
                paramMap.put("key", "true");
                break;
            case "nine":
                paramMap.put("word", "9");
                paramMap.put("key", "true");
                break;
            default :
                paramMap.put("key","false");
        }
        return paramMap;
    }
}
