package guenho.binary_search;

public class CrossingSteppingStone {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        solution(stones, 3);
    }

    private static int solution(int[] stones, int k) {
        int answer = 0;

        int left = 0;
        int right = stones.length - 1;
        boolean flag = true;
        int step = 0;

        while(flag) {

            for (int i = 0; i < stones.length; i++) {
                int stone = stones[i];
                if(stone < 0)  {
                    i+= k;
                }
                stones[i] -= stones[i]- step;
            }
            step ++;
        }



        return answer;
    }
}
