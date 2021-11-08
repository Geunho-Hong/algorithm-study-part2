package guenho.month_october;

public class NormalSquare {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w, h));
    }

    // 망가지는 사각형 = w + h - (w,h의 최대 공약수)

    private static long solution(int w, int h) {

        long w1 = Long.parseLong(String.valueOf(w));
        long h1 = Long.parseLong(String.valueOf(h));

        return (w1 * h1) - (w1+h1-gcd(w1,h1));
    }

    // Loop 유클리드 호제법
    private static long loopGcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // Recursive 유클리드 호제법
    private static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
