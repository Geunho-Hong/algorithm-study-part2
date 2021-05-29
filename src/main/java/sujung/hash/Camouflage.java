package sujung.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Camouflage {

    public int solution(String[][] clothes) {

        Map<String, List<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.computeIfAbsent(clothe[1], k -> new ArrayList<>()).add(clothe[0]);
        }

        int answer = 1;
        for (List<String> value : map.values()) {
            answer *= (value.size() + 1);
        }
        return answer - 1;
    }
}
