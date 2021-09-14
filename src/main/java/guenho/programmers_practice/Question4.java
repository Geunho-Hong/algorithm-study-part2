package guenho.programmers_practice;

public class Question4 {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] result = solution(lottos, win_nums);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];

        int maxGrade = 0;
        int minGrade = 0;
        int cnt = 0;
        int zeroCnt = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCnt++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    cnt++;
                    continue;
                }
            }
        }

        maxGrade = cnt + zeroCnt;
        minGrade = cnt;

        answer[0] = rank(maxGrade);
        answer[1] = rank(minGrade);

        return answer;
    }

    public static int rank(int num) {
        switch (num) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
