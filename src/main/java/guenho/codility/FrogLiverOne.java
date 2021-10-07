package guenho.codility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogLiverOne {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(5, arr));
    }

    private static int resolution(int X , int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if(A[i] <= X){ set.add(A[i]); }
            if(set.size() == X){
                return i;
            }
        }
        return -1;
    }

    // 시간 복잡도 초과로 인한 Resolution
    private static int solution(int x, int[] arr) {

        Map<Integer,Integer > paramMap = new HashMap<>();
        int answer = 0;

        // 순열이 채워지는 가장 빠른 Index 번호를 구한다
        for (int i = 0; i < arr.length; i++) {
            paramMap.put(arr[i], paramMap.getOrDefault(arr[i],0) + 1);

            if(check(paramMap,x)) {
                answer = i;
                break;
            } else {
                answer = -1;
            }
        }

        return answer;
    }

    private static boolean check(Map<Integer,Integer> paramMap, int x) {
        for (int i = 1; i <= x; i++) {
            if(!paramMap.containsKey(i)) {
                return false;
            }
        }
        return true;
    }
}
