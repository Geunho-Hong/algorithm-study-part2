package guenho.codility;

import java.util.HashMap;
import java.util.Map;

public class PermCheck {
    public static void main(String[] args) {
        int[] A = {4,1,3,2};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {

        // 개수를 체크할꺼면 -> Map
        // 그냥 여부를 파악할꺼면 -> Set

        
        if(A.length == 1 && A[0] > A.length) {
            return 0;
        }

        int answer = 1;
        long maxValue = 0;

        Map<Integer,Integer> numberMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if(A[i] > maxValue) {
                maxValue = A[i];
            }
            numberMap.put(A[i],numberMap.getOrDefault(A[i],0) + 1);
        }

        for (int i = 1; i <= maxValue; i++) {
            if(!numberMap.containsKey(i)){
                answer = 0;
                break;
            }
        }

        return answer;
    }
}
