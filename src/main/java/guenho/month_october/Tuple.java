package guenho.month_october;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        //String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        //String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        int[] answer = solution(s);
        for(int n : answer) {
            System.out.print(n + " ");
        }

        //System.out.println(solution(s));
    }

    private static int[] solution(String s) {

        int[] answer = {};

        String[] numberArray = s.split("},");
        LinkedHashSet<String> set = new LinkedHashSet<>();
        List<String[]> stringList = new ArrayList<>();

        /**
         * String s 를 쪼개 List 배열에 넣어 준다
         */
        for (int i = 0; i < numberArray.length; i++) {

            String num = numberArray[i]
                    .replaceAll("\\{", "")
                    .replaceAll("\\}", "");

            String[] numArr = num.split(",");
            stringList.add(numArr);
        }

        Collections.sort(stringList, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return s1.length - s2.length;
            }
        });

        for (int i = 0; i < stringList.size(); i++) {
            String[] arr = stringList.get(i);
            for(String v1 : arr) {
                set.add(v1);
            }
        }

        int idx = 0;
        answer = new int[set.size()];

        for(String v1 : set) {
            answer[idx] = Integer.parseInt(v1);
            idx++;
        }

        return answer;
    }
}
