package thkim.hash;

import java.util.HashMap;

public class HashMapLevel1 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String c : participant) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (String p : completion) {
            hashMap.put(p, hashMap.get(p) - 1);
        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) return key;
        }

        return answer;
    }
}
