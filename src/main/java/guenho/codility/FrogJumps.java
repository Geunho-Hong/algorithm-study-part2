package guenho.codility;

public class FrogJumps {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }

    private static int solution(int X, int Y, int D) {
        int val = Y - X;
        int solve = val / D;
        return val % D == 0 ? solve : solve + 1;
    }
}
