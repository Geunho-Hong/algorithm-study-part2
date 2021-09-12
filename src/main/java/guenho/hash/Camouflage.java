package guenho.hash;

import java.util.*;

public class Camouflage {
    public static void main(String[] args) {
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }

    private static int solution(String[][] clothes) {

        int answer = 1;
        Map<String, ArrayList<String>> map = new HashMap<>();

        /**
         * java8의 computeIfAbsent 사용시 보다 간결하게 처리 가능
         * ComputeIfAbsent
         * 1. Key 값이 있으면 값을 반환 한다
         * 2. Key 값이 없으면 연산을 수행후 값을 반환 한다
         */
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            String value = clothes[i][0];

            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }
        }

        /**
         * 옷을 입지 않는 경우의 수 고려 해서 (A+1) * (B+1) 연산
         */

        for(List<String> list : map.values()) {
            answer *= list.size() +1;
        }

        /**
         * 아무것도 입지 않는 경우 -1
         */
        return answer -1;
    }
}
