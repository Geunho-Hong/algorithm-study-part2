package guenho.hash;

// https://programmers.co.kr/learn/courses/30/lessons/42576

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnsuccessfulRunner {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    private static String solution(String[] participants, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String part : participants) {
            participantMap.put(part, participantMap.getOrDefault(part, 0) + 1);
        }

        for (String complete : completion) {
            int cnt = participantMap.get(complete);
            if (cnt == 1) {
                participantMap.remove(complete);
            } else {
                participantMap.put(complete, cnt - 1);
            }
        }

        return participantMap.keySet().iterator().next();
    }
}

