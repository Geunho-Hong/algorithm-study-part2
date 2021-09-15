package guenho;

public class PressKeyButton {

    private static int[][] position = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 1}, {3, 2}};

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int curLeft = 10; // *
        int curRight = 12;  // #

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number == 1 || number == 4 || number == 7) {
                curLeft = number;
                answer += "L";
            } else if (number == 3 || number == 6 || number == 9) {
                curRight = number;
                answer += "R";
            } else {

                if (number == 0) number = 11;

                int leftDistance = distance(curLeft, number);
                int rightDistance = distance(curRight, number);

                if (leftDistance == rightDistance) {
                    if (hand.equals("left")) {
                        answer += "L";
                        curLeft = number;
                    } else if (hand.equals("right")) {
                        answer += "R";
                        curRight = number;
                    }
                } else if (leftDistance > rightDistance) {
                    answer += "R";
                    curRight = number;
                } else if (rightDistance > leftDistance) {
                    answer += "L";
                    curLeft = number;
                }
            }
        }
        return answer;
    }

    private static int distance(int curPosition, int number) {

        int x = Math.abs(position[curPosition - 1][0] - position[number - 1][0]);
        int y = Math.abs(position[curPosition - 1][1] - position[number - 1][1]);

        return (x + y);
    }

}
