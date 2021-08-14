package min.toss;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
    }

    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료

        // 부가가치세
        long answer = 0;

        // 부가가치세 = 과세금액의 10% (소수점 첫째자리 올림)
        // 과세금액 = 공급가액 - 비과세금액 (부가가치세 부과 X)
        // 공급가액 = 공급대가 - 부가가치세
        // 공급대가 = 공급가액 + 부가가치세
        // 주문금액 = 공급대가 + 봉사료

        // 공급대가
        long supplyCost = orderAmount - serviceFee;
        // 공급대가 - 비과세금액이 1원일 경우 부가가치세는 0원
        if ((supplyCost - taxFreeAmount) == 1) return 0;

        return answer;
    }

}
