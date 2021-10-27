package guenho.month_october;

import java.util.Arrays;

/**
 * 1초 제한 시간 기준
 * O(n3) = 500
 * O(n2) = 2000
 * O(nlogn) = 100000
 */

public class LifeBoat {
    public static void main(String[] args) {
        //int[] people = {70, 50, 80, 50};
        int[] people = {70, 80, 50};
        int limit = 100;

        System.out.println(solution(people,limit));
    }

    private static int solution(int[] people, int limit) {
        /**
         * 구명 보트는 최대 2명씩 밖에 탈 수 없다
         * 최소한의 횟수로 옮기기 위해서
         * 가장 몸무게가 큰 사람 + 가장 몸무게가 작은 사람
         * 최대 무게를 가진 사람이 최소 무게를 가진 사람과 짝을 이뤄도
         * 구명 보트를 타지 못하면 그 사람은 혼자 탄다
         */

        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        Arrays.sort(people);

        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }

        return answer;
    }

}
