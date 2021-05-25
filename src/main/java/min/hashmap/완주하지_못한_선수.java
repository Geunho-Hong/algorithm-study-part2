package min.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class 완주하지_못한_선수 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        String result = solution.solution(participant, completion);
        System.out.println("result = " + result);
    }

    static class Solution {

        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> resultMap = new HashMap<>();

            return null;
        }
    }
}