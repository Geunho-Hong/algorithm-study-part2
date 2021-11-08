package guenho.month_october;

import java.util.*;

/**
 * 대략 1시간 50분 정도 풀이를 진행하였지만 성공하지 못함
 * 풀이 구성 방법
 * 1. 순열로 찾을 수 있는 모든 경우의 수를 구한다
 * 2. Key 값이 2개 이상 담긴 경우를 찾고 List 담는다
 */
public class MenuRenewal {

    private static boolean[] visited;
    private static String[] answerArr;
    private static Map<String, Integer> orderMap = new HashMap<>();

    public static void main(String[] args) {

        List<String> answerList = new ArrayList<String>();
        String[] answer = {};
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        answer = solution(orders,course);

        for(String s : answer) {
            System.out.println("s1 = " + s);
        }

    }

    private static String[] solution(String[] orders, int[] course) {

        // 단품 메뉴 조합 -> 코스 요리 (최소 2개 이상의 단품 메뉴로 구성)
        // 가장 많이 함께 주문한 단품메뉴가 코스요리 메뉴
        // 각각 분리해서 가져오는 개념은 아님


        List<String> answerList = new ArrayList<String>();
        String[] answer = {};

        // 코스 메뉴 조합의 모든 경우의 수 구하기
        for (int i = 0; i < orders.length; i++) {
            String[] orderArr = orders[i].split("");
            visited = new boolean[orderArr.length];
            for (int j = 0; j < course.length; j++) {
                answerArr = new String[course[j]];
                dfs(0, 0, course[j], orderArr);
            }
        }

        for (int i = 0; i < course.length; i++) {
            String maxKey = "";
            int maxValue = 0;

            for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
                if (entry.getValue() <= 1) {
                    continue;
                }
                if (entry.getKey().length() == course[i]) {
                    if (entry.getValue() > maxValue) {
                        maxValue = entry.getValue();
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
                if (entry.getValue() == maxValue && entry.getKey().length() == course[i]) {
                    maxKey += entry.getKey() + " ";
                }
            }
            if (maxKey.split(" ").length >= 2) {
                String[] keys = maxKey.split(" ");
                for (int j = 0; j < keys.length; j++) {
                    answerList.add(keys[j].trim());
                }
            } else {
                answerList.add(maxKey);
            }
        }

        answer = new String[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i).trim();
        }

        Arrays.sort(answer);
        return answer;
    }

    private static void dfs(int depth, int start, int N, String[] orderArr) {
        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            for (String s : answerArr) {
                sb.append(s);
            }
            orderMap.put(sb.toString(), orderMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < orderArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answerArr[depth] = orderArr[i];
                dfs(depth + 1, i + 1, N, orderArr);
                visited[i] = false;
            }
        }
    }
}
