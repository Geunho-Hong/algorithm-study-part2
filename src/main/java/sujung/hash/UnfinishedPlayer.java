package sujung.hash;

import java.util.HashMap;
import java.util.Map;

public class UnfinishedPlayer {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        for (String comp : completion) {
            int nums = map.get(comp);

            if (nums == 1) map.remove(comp);
            else map.put(comp, nums - 1);
        }
        return map.keySet().iterator().next();
    }
}
