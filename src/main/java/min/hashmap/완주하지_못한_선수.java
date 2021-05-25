package min.hashmap;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] participant = {"leo", "kiki", "eden", "leo"};
        String[] completion = {"kiki", "eden", "leo"};

        String result = solution.solution(participant, completion);
        System.out.println("result = " + result);
    }

    static class Solution {

        public String solution(String[] participant, String[] completion) {
            int capacity = (int) (participant.length * 1.3);
            Map<String, Integer> map = new HashMap<>(capacity);

            for (String player : participant) {
                map.put(player, map.getOrDefault(player, 0) + 1);
            }

            for (String finisher : completion) {
                Integer remain = map.get(finisher);
                if (remain == 1) {
                    map.remove(finisher);
                    continue;
                }
                map.put(finisher, --remain);
            }

            return map.keySet().iterator().next();
        }
    }
}