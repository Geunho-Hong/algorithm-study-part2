package min.toss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[][] res = solution.solution(2, false, new int[]{1, 2, 3, 4});
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] solution(int servers, boolean sticky, int[] requests) {
        int[][] result = new int[servers][requests.length / servers];

        if (sticky) {

        } else {
            int k = 0;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[j % servers][i] = requests[k++];
                }
            }
        }

        return result;
    }

}
