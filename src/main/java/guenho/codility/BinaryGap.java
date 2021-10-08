package guenho.codility;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(1041));
    }

    private static String makeBinaryNum(int N) {
        StringBuilder sb = new StringBuilder();


        while (N > 0) {
            sb.append(N % 2);
            N /= 2;
        }

        return sb.reverse().toString();
    }

    private static int solution(int N) {

        String binaryString = makeBinaryNum(1041);

        int zeroCount = 0;
        int gapLength = 0;

        for (int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(i) == '1') {
                if(zeroCount > gapLength) {
                    gapLength = zeroCount;
                    zeroCount = 0;
                }
            } else {
                zeroCount++;
            }
        }

        return gapLength;
    }
}
