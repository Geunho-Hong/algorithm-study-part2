package guenho.month_october;

import java.util.*;

/**
 * MenuRenewalSolve
 * reference : https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A9%94%EB%89%B4-%EB%A6%AC%EB%89%B4%EC%96%BC-java-2021-KAKAO-BLIND-RECRUITMENT
 */

public class MenuRenewalSolve {

    private static List<String> combination;

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        solution(orders,course);
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        combination = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {   // 한 주문당 모든 조합 구하기
            char[] orders_char = orders[i].toCharArray();
            Arrays.sort(orders_char);

            for (int index = 0; index < orders_char.length - 1; index++) {  // 차례대로 한글자씩 선택 후
                for (int j = 0; j < course.length; j++) {   // course 에 있는 모든 경우
                    dfs(orders_char, index, 1, course[j], String.valueOf(orders_char[index]));
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (String key : combination) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int max_value = 0;

            for (String key : keySetList) {
                if (map.get(key) >= 2 && key.length() == course[i]) {
                    if (map.get(key) >= max_value) {
                        ansList.add(key);
                        max_value = map.get(key);
                    }
                }
            }
        }
        Collections.sort(ansList);
        answer = new String[ansList.size()];
        ansList.toArray(answer);

        return answer;
    }

    public static void dfs(char[] arr, int idx, int length, int course, String str) {
        if (length == course) {    // 경우의 수 추가
            combination.add(str);
        }

        for (int i = idx + 1; i < arr.length; i++) {
            dfs(arr, i, length + 1, course, str + arr[i]);
        }
    }
}
